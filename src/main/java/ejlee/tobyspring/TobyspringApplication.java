package ejlee.tobyspring;

import ejlee.tobyspring.hello.HelloController;
import ejlee.tobyspring.hello.MyHelloApplication;
import ejlee.tobyspring.hello.MySpringBootAnnotation;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootAnnotation
public class TobyspringApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }


    public static void main(String[] args) {
        MyHelloApplication.run(TobyspringApplication.class, args);
    }
}
