package travelApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travelApp.entity.Activity;
import travelApp.repository.custom.CustomActivityRepository;

@Repository
public interface ActivityRepository
        extends JpaRepository<Activity, String>, CustomActivityRepository {
}
