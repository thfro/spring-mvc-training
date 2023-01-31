package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.List;

@Configuration
// equivalent to <mvc:annotation-driven /> if using XML Configuration
// enables support for @Controller-annotated classes that use @RequestMapping to map incoming requests to methods
@EnableWebMvc
// equivalent to <context:component-scan> if using XML Configuration
// where to search for these annotated classes
@ComponentScan({ "com.example" })
public class MyMvcConfig implements WebMvcConfigurer {

    // Use implementation of HttpMessageConverter that can read and write JSON using Jackson 2.x's ObjectMapper.
    // This converter can be used to bind to typed beans, or untyped HashMap instances.
    // By default, this converter supports application/json and application/*+json with UTF-8 character set.
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        messageConverters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker().cache(true).prefix("").suffix(".ftl");
    }

    /* alternative Konfigurationsoption für den FreeMarkerViewResolver
    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }
    */

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        // alternativ: "/WEB-INF/views/" => dafür dann den Projektordner src/webapp/WEB-INF/views anlegen
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates");
        return freeMarkerConfigurer;
    }
}
