package ejlee.tobyspring;

import ejlee.tobyspring.hello.HelloController;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobyspringApplication {

    public static void main(String[] args) {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(); // 추상클래스 -> Embedded Tomcat 을 이용
        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어 등등
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        //request
                        String name = req.getParameter("name");

                        // name 추출
                        String hello = helloController.hello(name);

                        // response
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(hello); // request 는 helloController 가 처리
                    } else if (req.getRequestURI().equals("/user")) {
                        // response
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println("Hello... " + "어진이니?");
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            })
                    .addMapping("/*"); // url mapping -> 모든 url 을 검증하겠다
        }); // ServletContextInitializer 는 서블릿 컨테이너에다가 서블릿 등록하는데 지원해주는 클래스
        webServer.start();
    }
}
