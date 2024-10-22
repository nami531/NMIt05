package nmi.nmit02e03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.micrometer.common.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    public void addViewControllers(@NonNull ViewControllerRegistry registry){
        registry.addViewController("/external-urlView").setViewName("external-urlView");
    }
}
