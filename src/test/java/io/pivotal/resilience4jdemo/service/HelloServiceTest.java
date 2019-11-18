package io.pivotal.resilience4jdemo.service;

import io.pivotal.resilience4jdemo.dao.HelloDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HelloServiceTest {

    @MockBean
    private HelloDao helloDao;

    @Autowired
    private HelloService helloService;

    @Test
    public void test_get_hello() {
        when(helloDao.getHello()).thenReturn("Hello world\n");

        assertEquals("Hello world\n", helloService.getHello());
    }
}
