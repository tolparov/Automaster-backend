package com.example.Automaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void TestRegister() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "register",
                String.class)).contains("register");
    }
    @Test
    void TestLogin() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "login",
                String.class)).contains("Please sign in");
    }
}