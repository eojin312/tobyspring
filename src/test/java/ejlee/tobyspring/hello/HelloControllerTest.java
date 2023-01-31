package ejlee.tobyspring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastTest {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {}

class HelloControllerTest {

    @FastTest
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        assertThat(ret).isEqualTo("Test");
    }


    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void failsHelloControllerForBlank() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);

        String ret = helloDecorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}