package com.dongle.graphx;

import com.dongle.graphx.Dao.NodeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraphxApplicationTests {
    @Autowired
    private NodeDao nodeDao;

    @Test
    void contextLoads() {
        System.out.println("\\>".replaceAll("\\\\>", ">"));
    }

}
