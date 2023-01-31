package ejlee.tobyspring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;
    private final ApplicationContext context;

    public HelloController(HelloService helloService, ApplicationContext context) {
        this.helloService = helloService;
        this.context = context;

        System.out.println(context);
    }

    @GetMapping("/hello")
    @ResponseBody // dispatherServlet 은 응답 타입이 string 이면, veiw 페이지를 찾는데, 우리는 String 그대로 내려주고싶어서 responseBody 붙임
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
