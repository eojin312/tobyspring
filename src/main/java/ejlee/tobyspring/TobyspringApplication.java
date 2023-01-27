package ejlee.tobyspring;

import ejlee.tobyspring.hello.HelloController;
import ejlee.tobyspring.hello.SimpleHelloService;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TobyspringApplication {

    public static void main(String[] args) {
        // 스프링컨테이너 만들기
        GenericWebApplicationContext genericApplicationContext = new GenericWebApplicationContext(); // 어플리케이션
        genericApplicationContext.registerBean(SimpleHelloService.class); // 빈 등록
        genericApplicationContext.registerBean(HelloController.class); // 빈 등록
        genericApplicationContext.refresh(); // 초기화

        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(); // 추상클래스 -> Embedded Tomcat 을 이용

        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatherServlet", new DispatcherServlet(genericApplicationContext))
                    .addMapping("/*"); // url mapping -> 모든 url 을 검증하겠다
        }); // ServletContextInitializer 는 서블릿 컨테이너에다가 서블릿 등록하는데 지원해주는
        webServer.start();
    }
}
