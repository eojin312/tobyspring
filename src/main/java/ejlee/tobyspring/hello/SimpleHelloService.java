package ejlee.tobyspring.hello;

public class SimpleHelloService implements HelloService{


    @Override
    public String sayHello(String name) {
        return name;
    }
}
