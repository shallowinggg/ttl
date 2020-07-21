package io.github.shallowinggg.ttl.handler;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.lang.Nullable;

/**
 * @author ding shimin
 * @since 1.0
 */
public interface ConfigurableTaskHandler extends TaskHandler {

    /**
     * Set the {@link ConfigurableConversionService} to be used when performing type
     * conversions on properties.
     * <p><strong>Note:</strong> as an alternative to fully replacing the
     * {@code ConversionService}, consider adding or removing individual
     * {@code Converter} instances by drilling into {@link #getConversionService()}
     * and calling methods such as {@code #addConverter}.
     *
     * @param conversionService the conversionService to set
     * @see #getConversionService()
     * @see org.springframework.core.convert.converter.ConverterRegistry#addConverter
     */
    void setConversionService(ConversionService conversionService);

    /**
     * Return the {@link ConfigurableConversionService} used when performing type
     * conversions on properties.
     * <p>The configurable nature of the returned conversion service allows for
     * the convenient addition and removal of individual {@code Converter} instances:
     * <pre class="code">
     * ConfigurableConversionService cs = env.getConversionService();
     * cs.addConverter(new FooConverter());
     * </pre>
     *
     * @return conversionService that used
     * @see org.springframework.core.convert.converter.ConverterRegistry#addConverter
     */
    ConversionService getConversionService();

    /**
     * Return the name for this task handler.
     *
     * @return the handler name
     */
    @Nullable
    String getHandlerName();

    /**
     * Set the name for this task handler.
     *
     * @param handlerName the handlerName to set
     */
    void setHandlerName(String handlerName);

}
