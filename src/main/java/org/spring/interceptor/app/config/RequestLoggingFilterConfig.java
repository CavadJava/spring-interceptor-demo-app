package org.spring.interceptor.app.config;

import org.spring.interceptor.app.interceptor.CustomUrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public FilterRegistrationBean<CustomUrlFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomUrlFilter> registrationBean = new FilterRegistrationBean();
        CustomUrlFilter customUrlFilter = new CustomUrlFilter();

        registrationBean.setFilter(customUrlFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
