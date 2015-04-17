package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;
import org.springframework.web.servlet.view.mustache.jmustache.JMustacheTemplateFactory;
import org.springframework.web.servlet.view.mustache.jmustache.JMustacheTemplateLoader;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "webapp" })
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**/*.html").addResourceLocations("/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");        
    }


    @Bean
    public ViewResolver viewResolver() {

        MustacheViewResolver viewResolver = new MustacheViewResolver();
        viewResolver.setCache(false); // development only
        viewResolver.setTemplateFactory(templateFactory());

        return viewResolver;
    }


    @Bean
    public JMustacheTemplateFactory templateFactory() {

        JMustacheTemplateFactory templateFactory = new JMustacheTemplateFactory();
        templateFactory.setTemplateLoader(templateLoader());
        templateFactory.setSuffix(".html");

        return templateFactory;
    }


    @Bean
    public JMustacheTemplateLoader templateLoader() {

        JMustacheTemplateLoader templateLoader = new JMustacheTemplateLoader();

        return templateLoader;
    }
}
