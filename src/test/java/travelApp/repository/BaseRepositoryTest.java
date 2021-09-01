package travelApp.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
public class BaseRepositoryTest {

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
