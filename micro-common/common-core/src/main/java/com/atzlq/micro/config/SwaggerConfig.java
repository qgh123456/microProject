package com.atzlq.micro.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lizihao
 * @version 1.0
 * @date 2020/3/10 17:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 这个是除了被分组之外的都在这里显示(default)
     * @return
     */
/*    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }*/

    @Bean("用户服务")
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户服务")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 所有标了API注解的才在文档中展示
                .paths(PathSelectors.regex("/user.*")) // user下的所有请求
                .build()
                .apiInfo(userApiInfo())
                .enable(true);
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("用户服务接口文档")
                .description("提供用户服务的文档")
                .termsOfServiceUrl("http://http://www.bmsoft.com.cn/")
                .version("1.0")
                .build();
    }


    @Bean("角色服务")
    public Docket roleApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("角色服务")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 所有标了API注解的才在文档中展示
                .paths(PathSelectors.regex("/role.*")) // role下的所有请求
                .build()
                .apiInfo(roleApiInfo())
                .enable(true);
    }

    private ApiInfo roleApiInfo() {
        return new ApiInfoBuilder()
                .title("角色服务")
                .description("提供角色服务的文档")
                .termsOfServiceUrl("http://http://www.bmsoft.com.cn/")
                .version("1.0")
                .build();
    }

}
