package ejlee.tobyspring;

import ejlee.tobyspring.hello.HelloController;
import ejlee.tobyspring.hello.MyHelloApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 스프링 구성정보다 설정해주는 것
@ComponentScan // Component 가 붙어져있는 클래스를 모두 빈으로 등록해줌
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
