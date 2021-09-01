package travelApp.repository.custom;

import travelApp.entity.Activity;

import java.util.List;

public interface CustomActivityRepository {

    List<Activity> findActivitiesWithSpaces();

}
