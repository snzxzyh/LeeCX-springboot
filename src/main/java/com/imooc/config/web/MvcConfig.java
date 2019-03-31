package com.imooc.config.web;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/baidu/work/image/upload");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Bean(name="viewResolver")
    public ViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setApplicationContext(this.applicationContext);
        viewResolver.setCache(false);
        viewResolver.setPrefix("/WEB-INF/center/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name="multipartResolver")
    public StandardServletMultipartResolver createStandardServletMultipartResolver(){
        StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
        return standardServletMultipartResolver;
    }
    @Value("${kaptcha.border}")
    private String border;
    @Value("${kaptcha.textproducer.font.color}")
    private String fcolor;
    @Value("${kaptcha.image.width}")
    private String width;
    @Value("${kaptcha.textproducer.char.string}")
    private String cString;
    @Value("${kaptcha.image.height}")
    private String height;
    @Value("${kaptcha.textproducer.font.size}")
    private String fsize;
    @Value("${kaptcha.noise.color}")
    private String nColor;
    @Value("${kaptcha.textproducer.char.length}")
    private String clength;
    @Value("${kaptcha.textproducer.font.names}")
    private String fnames;
    @Bean
    public ServletRegistrationBean servletRegistrationBean() throws ServletException{
        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(),"/Kaptcha");
        servlet.addInitParameter("kaptcha.border",border);
        servlet.addInitParameter("kaptcha.textproducer.font.color",fcolor);
        servlet.addInitParameter("kaptcha.image.width",width);
        servlet.addInitParameter("kaptcha.textproducer.char.string",cString);
        servlet.addInitParameter("kaptcha.image.height",height);
        servlet.addInitParameter("kaptcha.textproducer.font.size",fsize);
        servlet.addInitParameter("kaptcha.noise.color",nColor);
        servlet.addInitParameter("kaptcha.textproducer.char.length",clength);
        servlet.addInitParameter("kaptcha.textproducer.font.names",fnames);
        return servlet;
    }
}

















