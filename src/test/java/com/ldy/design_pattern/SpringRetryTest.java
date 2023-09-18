package com.ldy.design_pattern;

import com.ldy.DemoApplication;
import com.ldy.retry.SpringRetryDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringRetryTest {

    @Autowired
    SpringRetryDemo springRetryDemo;

    @Test
    public void test() throws Exception {
        springRetryDemo.call("123456");
    }
}
