package ejlee.tobyspring.hello;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

    public static void run(Class<?> applicationClass, String... args) {
        // 스프링컨테이너 만들기
        AnnotationConfigWebApplicationContext genericApplicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory servletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                // Bean 으로 등록한 Factory 와 DispatcherServlet 사용하기
                WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatherServlet", dispatcherServlet)
                            .addMapping("/*"); // url mapping -> 모든 url 을 검증하겠다
                }); // ServletContextInitializer 는 서블릿 컨테이너에다가 서블릿 등록하는데 지원해주는
                webServer.start();
            }
        };
        genericApplicationContext.register(applicationClass); // 자바코드로 구성정보를 등록해줘야해서 register 호출
        genericApplicationContext.refresh(); // 스프링 컨테이너 초기화
    }
}
