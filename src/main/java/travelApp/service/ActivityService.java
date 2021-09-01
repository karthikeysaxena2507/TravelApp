package travelApp.service;

import org.springframework.stereotype.Service;
import travelApp.entity.Activity;
import travelApp.repository.ActivityRepository;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivitiesBySpaces() {
        return activityRepository.findActivitiesWithSpaces();
    }

}
