package ejlee.tobyspring;

import ejlee.tobyspring.hello.HelloController;
import ejlee.tobyspring.hello.HelloService;
import ejlee.tobyspring.hello.SimpleHelloService;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 스프링 구성정보다 설정해주는 것
public class TobyspringApplication {

    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    };

    public static void main(String[] args) {
        // 스프링컨테이너 만들기
        AnnotationConfigWebApplicationContext genericApplicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(); // 추상클래스 -> Embedded Tomcat 을 이용

                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatherServlet",
                                    new DispatcherServlet(this))
                            .addMapping("/*"); // url mapping -> 모든 url 을 검증하겠다
                }); // ServletContextInitializer 는 서블릿 컨테이너에다가 서블릿 등록하는데 지원해주는
                webServer.start();
            }
        };
        genericApplicationContext.register(TobyspringApplication.class); // 자바코드로 구성정보를 등록해줘야해서 register 호출
        genericApplicationContext.refresh(); // 스프링 컨테이너 초기화
    }
}
