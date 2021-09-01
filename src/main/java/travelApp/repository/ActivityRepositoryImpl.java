package travelApp.repository;

import travelApp.entity.Activity;
import travelApp.repository.custom.CustomActivityRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ActivityRepositoryImpl implements CustomActivityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Activity> findActivitiesWithSpaces() {
        TypedQuery<Activity> query = getEntityManager().createNamedQuery(
                "getActivitiesBySpaces",
                Activity.class
        );
        List<Activity> activityList = query.getResultList();
        return activityList;
    }
}
