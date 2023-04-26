package ejlee.tobyspring.hello;

import ejlee.tobyspring.config.autoConfig.DispatcherServletConfig;
import ejlee.tobyspring.config.autoConfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // java annotation 은 class 라 runtime 시점까지 살아있도록하기위함
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@ComponentScan
@Configuration
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})
public @interface MySpringBootAnnotation {
}
