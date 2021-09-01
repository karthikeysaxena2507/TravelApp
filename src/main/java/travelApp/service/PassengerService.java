package travelApp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelApp.entity.Activity;
import travelApp.entity.Passenger;
import travelApp.exception.InvalidOperationException;
import travelApp.model.PassengerModel;
import travelApp.repository.ActivityRepository;
import travelApp.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public PassengerService(
            PassengerRepository passengerRepository,
            ActivityRepository activityRepository
            ) {
        this.passengerRepository = passengerRepository;
        this.activityRepository = activityRepository;
    }

    public PassengerModel getPassengerDetails(String passengerName) {
        Passenger passenger = passengerRepository.findById(passengerName)
                .orElseThrow(NoSuchElementException::new);
        return new PassengerModel(
                passenger.getPassengerName(),
                passenger.getPassengerNumber(),
                passenger.getBalance(),
                passenger.getPassengerType(),
                passenger.getActivities()
        );
    }

    public Passenger updatePassengerActivity(
            String passengerName,
            String activityName
    ) throws InvalidOperationException {

        Activity activity = activityRepository.findById(activityName)
                .orElseThrow(NoSuchElementException::new);
        Long activityCapacity = activity.getCapacity();
        Double activityCost = activity.getCost();

        if (activityCapacity > 0) {

            Passenger passenger = passengerRepository.findById(passengerName)
                    .orElseThrow(NoSuchElementException::new);
            String passengerType = passenger.getPassengerType();
            Double passengerBalance = passenger.getBalance();
            Double activityPrice = 0.0;

            log.info("passenger Type: {}", passengerType);

            if (passengerType.equals("STANDARD")) {
                activityPrice = activityCost;
                if (passengerBalance >= activityPrice) {
                    passenger.setBalance(passengerBalance - activityPrice);
                }
                else {
                    throw new InvalidOperationException("Insufficient Balance");
                }
            }
            else if (passengerType.equals("GOLD")) {
                activityPrice = activityCost - (0.1 * activityCost);
                log.info("activity price is {}", activityPrice);
                if (passengerBalance >= activityPrice) {
                    passenger.setBalance(passengerBalance - activityPrice);
                }
                else {
                    throw new InvalidOperationException("Insufficient Balance");
                }
            }

            List<Activity> passengerActivities = passenger.getActivities();

            if(passengerActivities == null) {
                passengerActivities = new ArrayList<>();
            }

            passengerActivities.add(activity);

            passenger.setActivities(passengerActivities);

            activity.setCapacity(activity.getCapacity() - 1);
            activityRepository.save(activity);
            return passengerRepository.save(passenger);
        }
        else {
            throw new InvalidOperationException("activity is full");
        }
    }

}
