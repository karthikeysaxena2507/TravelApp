package travelApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

@Slf4j
public class BaseControllerTest {

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
