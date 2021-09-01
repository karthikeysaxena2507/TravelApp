package travelApp.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import travelApp.entity.Activity;
import travelApp.service.ActivityService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActivityController.class)
class ActivityControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActivityService activityService;

    @Test
    void getActivitiesWithSpaces() throws Exception {

        Mockito.when(activityService.getActivitiesBySpaces())
               .thenReturn(getActivityList());

        mockMvc.perform(
                    get("/activities")
                   .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].activityName").value("surfing"))
                .andExpect(jsonPath("$").isArray());

    }

    private List<Activity> getActivityList() {

        Activity activity = new Activity();
        activity.setActivityName("surfing");
        activity.setDescription("cool water sport");
        activity.setCost(1000.0);
        activity.setCapacity(2L);
        List<Activity> activities = new ArrayList<>();
        activities.add(activity);
        return activities;

    }


}