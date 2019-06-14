/**
 * 
 */
package com.extentia.example.location.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Pranav.Kadam
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo())
          .tags(new Tag("LocationController", "Provide APIS for location."));
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API").description("Provide location related APIs (Search/Autocomplete/Near-By) by giving text input using third party APIs like Google and Foursquare.").version("1.0.0").build();
    }
    
}
