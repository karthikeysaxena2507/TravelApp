package travelApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
public class Package {

    @Id
    @Column(name = "package_name", nullable = false, unique = true)
    private String packageName;

    @Column(name = "passenger_capacity", nullable = false)
    private Long passengerCapacity;

    @OneToMany(
            targetEntity = Destination.class,
            mappedBy = "packageItem",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Destination> destinations;

    @OneToMany(
            targetEntity = Passenger.class,
            mappedBy = "packageItem",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Passenger> passengers;

}
