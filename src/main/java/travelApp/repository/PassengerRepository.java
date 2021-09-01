package travelApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travelApp.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {

}
