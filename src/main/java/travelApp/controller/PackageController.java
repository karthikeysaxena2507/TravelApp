package travelApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelApp.entity.Package;
import travelApp.model.PackageItinerary;
import travelApp.model.PassengerList;
import travelApp.service.PackageService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/packages")
@Slf4j
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAllPackages() {
        return new ResponseEntity<>(
                packageService.getAllPackages(),
                HttpStatus.OK
        );
    }

    @GetMapping("/itinerary")
    public ResponseEntity<PackageItinerary> getPackageItinerary(
            @Valid @RequestParam String packageName
    ) {
        return new ResponseEntity<>(
                packageService.getPackageItinerary(packageName),
                HttpStatus.OK);
    }

    @GetMapping("/passenger")
    public ResponseEntity<PassengerList> getPassengersByPackage(
            @Valid @RequestParam String packageName
    ) {
        return new ResponseEntity<>(
                packageService.getPassengerListByPackage(packageName),
                HttpStatus.OK
        );
    }

    @GetMapping("/package")
    public ResponseEntity<Package> getPackageByPackageName(
            @Valid @RequestParam String packageName
    ) {
        log.info("package name is {}", packageName);
        return new ResponseEntity<>(
                packageService.getPackageById(packageName),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Package> addPackage(
            @Valid @RequestBody Package newPackage
    ) {
        return new ResponseEntity<>(
                packageService.addPackage(newPackage),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<Package> updatePackage(
            @Valid @RequestBody Package newPackage
    ) {
        return new ResponseEntity<>(
                packageService.addPackage(newPackage),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<String> deletePackageByName(
            @Valid @RequestParam String packageName
    ) {
        packageService.deletePackageById(packageName);
        return new ResponseEntity<>(
                "DELETED SUCCESSFULLY",
                HttpStatus.OK
        );
    }

}
