package ejlee.tobyspring.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello") // dispatherServlet 이 찾을 수 쉽게 클래스단에 적용
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody // dispatherServlet 은 응답 타입이 string 이면, veiw 페이지를 찾는데, 우리는 String 그대로 내려주고싶어서 responseBody 붙임
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
