package ejlee.tobyspring;

import ejlee.tobyspring.hello.MyHelloApplication;
import ejlee.tobyspring.hello.MySpringBootAnnotation;

@MySpringBootAnnotation
public class TobyspringApplication {
    public static void main(String[] args) {
        MyHelloApplication.run(TobyspringApplication.class, args);
    }
}
