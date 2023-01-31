package ejlee.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring
        // HTTPie

        TestRestTemplate restTemplate = new TestRestTemplate();

        // ResponseEntity 웹 요소를 모두 가지고있는 객체
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // status 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header content-type 이 text/plain
        // body Hello Spring
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failsHelloApi() {
        // http localhost:8080/hello?name=Spring
        // HTTPie

        TestRestTemplate restTemplate = new TestRestTemplate();

        // ResponseEntity 웹 요소를 모두 가지고있는 객체
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8080/hello?name=", String.class, "");

        // status 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
