package com.nacre.ttl.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * Base class for {@code TaskHandler} that provide type conversion
 * functionality.
 * <p>
 * Sub class should exec task with arguments that has converted instead
 * of arguments passed for method {@link #invoke(Object...)}.
 *
 * @author ding shimin
 * @date 2020/7/20
 * @see MethodReflectTaskHandler
 * @since 1.0
 */
public abstract class AbstractTaskHandler implements ConfigurableTaskHandler {

    protected final Log logger = LogFactory.getLog(getClass());

    private static final Class<?>[] EMPTY_CLASSES = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    protected ConversionService conversionService;

    protected final Class<?>[] argTypes;

    protected final Object[] actualArgs;

    protected String handlerName;

    protected AbstractTaskHandler(Class<?>[] argTypes) {
        if (ObjectUtils.isEmpty(argTypes)) {
            this.argTypes = EMPTY_CLASSES;
            this.actualArgs = EMPTY_OBJECT_ARRAY;
        } else {
            this.argTypes = argTypes;
            this.actualArgs = new Object[argTypes.length];
        }
    }

    @Override
    public void setConversionService(ConversionService conversionService) {
        Assert.notNull(conversionService, "conversionService must not be null");
        this.conversionService = conversionService;
    }

    @Override
    public ConversionService getConversionService() {
        ConversionService conversionService = this.conversionService;
        if (conversionService == null) {
            conversionService = DefaultConversionService.getSharedInstance();
            this.conversionService = conversionService;
        }
        return conversionService;
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }

    @Override
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void invoke(Object... args) throws Exception {
        if (argTypes != EMPTY_CLASSES) {
            if (ObjectUtils.isEmpty(args) || args.length != argTypes.length) {
                throw new ArgumentNotMatchException(argTypes, args);
            }

            ConversionService conversionService = getConversionService();
            for (int i = 0; i < argTypes.length; ++i) {
                actualArgs[i] = conversionService.convert(args[i], argTypes[i]);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Exec task handler: " + getHandlerName() +
                    ", original args: " + Arrays.toString(args) +
                    ", param types: " + Arrays.toString(argTypes) +
                    ", converted args: " + Arrays.toString(actualArgs));
        }
        invokeInternal();
    }

    /**
     * Sub class should implement this method and do actual task
     * execution with args that converted.
     *
     * @throws Exception if underlying task exec fail
     * @see #actualArgs
     */
    protected abstract void invokeInternal() throws Exception;
}
