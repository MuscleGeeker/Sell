package me.musclegeeker.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LoggerTest {


    @Test
    public void test1() {
        log.info("info");
        log.error("error");
    }
}
