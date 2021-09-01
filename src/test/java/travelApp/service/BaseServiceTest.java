package travelApp.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BaseServiceTest {

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("*********** TEST STARTS ***********");
        log.info("TESTING {} method", testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown() {
        log.info("*********** TEST ENDS ***********");
    }

}
