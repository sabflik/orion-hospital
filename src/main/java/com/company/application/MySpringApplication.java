package com.company.application;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletContextListener;

/**
 * <p>Entry point into Spring boot application</p>
 * @author Chang Kon Han
 * @author John Law
 * @author Wesley Yep
 * @since 29 Feb 2016
 */
@SpringBootApplication
@ComponentScan({"com.company.controller"})
@EnableAutoConfiguration
public class MySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class, args);
    }

    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> {
            // Resteasy configuration
            servletContext.setInitParameter("resteasy.scan", "true");
            servletContext.setInitParameter("resteasy.servlet.mapping.prefix", "/services");
        };
    }

    @Bean
    public ServletContextListener restEasyBootstrap() {
        return new ResteasyBootstrap();
    }

    @Bean
    public ServletRegistrationBean restEasyServlet() {
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new HttpServletDispatcher());
        registrationBean.setName("athena-resteasy");
        registrationBean.addUrlMappings("/services/*");
        registrationBean.addInitParameter("javax.ws.rs.Application", "com.company.application.MyRestApplication");
        return registrationBean;
    }

}
