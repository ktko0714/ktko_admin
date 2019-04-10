package com.ktko.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:/test.yml")
@SpringBootTest
public class TestApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void propertyTest() {
        System.out.println("TEST ===== : " + environment.getProperty("adminDb.userName"));
        assertThat(environment.getProperty("adminDb.userName")).isEqualTo("root1");
    }
}
