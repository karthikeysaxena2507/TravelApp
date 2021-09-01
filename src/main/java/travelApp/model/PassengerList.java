package travelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travelApp.entity.Passenger;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerList {

    private String packageName;

    private Long passengerCapacity;

    private int enrolledPassengers;

    private List<Passenger> passengers;

}
