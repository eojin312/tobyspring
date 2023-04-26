package ejlee.tobyspring.config;

import ejlee.tobyspring.hello.MyHelloApplication;
import ejlee.tobyspring.hello.MySpringBootAnnotation;

@MySpringBootAnnotation
public class TobyspringApplication {

    // TODO : 빈 오브젝트 역할과 구분부터
    public static void main(String[] args) {
        MyHelloApplication.run(TobyspringApplication.class, args);
    }
}
