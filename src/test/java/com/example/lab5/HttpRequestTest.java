package com.example.lab5;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/buddyInfoes/1",
                String.class)).contains("Ryan");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/buddyInfoes/2",
                String.class)).contains("John");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/buddyInfoes/3",
                String.class)).contains("Sammy");

    }
}