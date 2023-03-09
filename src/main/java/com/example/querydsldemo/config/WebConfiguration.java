package com.example.querydsldemo.config;

import org.springdoc.core.customizers.QuerydslPredicateOperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.querydsl.binding.QuerydslBindingsFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //some config


  @Bean
  public QuerydslPredicateOperationCustomizer querydslPredicateOperationCustomizer(QuerydslBindingsFactory querydslBindingsFactory) {
     return new QuerydslPredicateOperationCustomizer(querydslBindingsFactory);
  }

    //other config
}
