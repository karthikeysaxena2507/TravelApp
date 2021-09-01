package travelApp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import travelApp.service.PassengerService;

@WebMvcTest(controllers = PassengerController.class)
class PassengerControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PassengerService passengerService;

    @Test
    void getPassengerDetails() {
    }

    @Test
    void updatePassengerActivity() {
    }
}