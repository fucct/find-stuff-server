package com.fucct.findstuff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fucct.findstuff.login.LoginTypeConverter;

@Configuration
public class ConverterConfig extends WebMvcConfigurationSupport {
    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService formattingConversionService = super.mvcConversionService();
        formattingConversionService.addConverter(new LoginTypeConverter());
        return formattingConversionService;
    }
}
