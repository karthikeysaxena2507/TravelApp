package travelApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travelApp.entity.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {

}
