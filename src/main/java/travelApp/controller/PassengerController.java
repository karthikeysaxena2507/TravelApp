package travelApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelApp.entity.Passenger;
import travelApp.exception.InvalidOperationException;
import travelApp.model.PassengerModel;
import travelApp.service.PassengerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/passengers")
@Slf4j
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<PassengerModel> getPassengerDetails(
            @Valid @RequestParam String passengerName) {
        return new ResponseEntity<>(
                passengerService.getPassengerDetails(passengerName),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Passenger> updatePassengerActivity(
            @Valid @RequestParam String activityName,
            @Valid @RequestParam String passengerName
    ) throws InvalidOperationException {

        return new ResponseEntity<>(
                passengerService.updatePassengerActivity(
                        passengerName,
                        activityName
                ), HttpStatus.OK
        );

    }

}
