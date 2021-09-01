package travelApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelApp.entity.Package;
import travelApp.model.PackageItinerary;
import travelApp.model.PassengerList;
import travelApp.repository.PackageRepository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Package getPackageById(String packageName) {
        return packageRepository.findById(packageName)
                .orElseThrow(NoSuchElementException::new);
    }

    public Package addPackage(Package newPackage) {
        return packageRepository.save(newPackage);
    }

    public void deletePackageById(String packageName) {
        Package packageItem = packageRepository.findById(packageName)
                .orElseThrow(NoSuchElementException::new);
        packageRepository.deleteById(packageName);
    }

    public PackageItinerary getPackageItinerary(String packageName) {
        Package packageItem = packageRepository.findById(packageName)
                .orElseThrow(NoSuchElementException::new);
        return new PackageItinerary(
                packageName,
                packageItem.getDestinations());
    }

    public PassengerList getPassengerListByPackage(String packageName) {
        Package packageItem = packageRepository.findById(packageName)
                .orElseThrow(NoSuchElementException::new);
        return new PassengerList(
                packageName,
                packageItem.getPassengerCapacity(),
                packageItem.getPassengers().size(),
                packageItem.getPassengers()
        );
    }

}
