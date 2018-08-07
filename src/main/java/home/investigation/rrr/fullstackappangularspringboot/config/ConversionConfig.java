package home.investigation.rrr.fullstackappangularspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter>  converters = new HashSet<Converter>();
        return converters;
    }

    ConversionService conversionService() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(getConverters());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

}