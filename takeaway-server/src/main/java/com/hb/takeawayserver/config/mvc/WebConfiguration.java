package com.hb.takeawayserver.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hb
 * @creat 2022-10-06-2022/10/6
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 资源映射到本地路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:D:/takeaway/upload/");
    }

}
