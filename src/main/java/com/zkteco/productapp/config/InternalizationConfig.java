package com.zkteco.productapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class InternalizationConfig implements WebMvcConfigurer {

    Locale locale = Locale.getDefault();

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource localeMessageResource = new ReloadableResourceBundleMessageSource();
        localeMessageResource.setBasename("classpath:internalizationLang");
        localeMessageResource.setUseCodeAsDefaultMessage(true);
        return localeMessageResource;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("accept-language");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    LocaleResolver localeResolver() {
        return new InternalizationFilter();
    }

    public String locale(String localeKey) {
        Locale langLocale = LocaleContextHolder.getLocale();
        return messageSource().getMessage(localeKey, null, langLocale);
    }
}
