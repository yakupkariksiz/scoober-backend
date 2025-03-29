package com.scoober.scoober_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "order_placed" })
class ScooberBackendApplicationTests {
    @Test
    void contextLoads() {}
}

