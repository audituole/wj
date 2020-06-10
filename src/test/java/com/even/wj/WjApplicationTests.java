package com.even.wj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.HtmlUtils;

@SpringBootTest
class WjApplicationTests {

    @Test
    void contextLoads() {
        String head = HtmlUtils.htmlEscape("<head>");
        System.out.println("---------");
    }

}
