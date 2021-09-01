package travelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travelApp.entity.Activity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerModel {

    private String passengerName;

    private Long passengerNumber;

    private Double balance;

    private String passengerType;

    List<Activity> activities;

}
