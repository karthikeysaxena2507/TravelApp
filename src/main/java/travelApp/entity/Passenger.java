package travelApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "passengers")
@NoArgsConstructor
public class Passenger {

    @Id
    @Column(name = "passenger_name", nullable = false, unique = true)
    private String passengerName;

    @Column(name = "passenger_number", nullable = false)
    private Long passengerNumber;

    @Column(name = "passenger_type", nullable = false)
    private String passengerType;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "package_name", nullable = false)
    @JsonBackReference
    private Package packageItem;

    @ManyToMany
    @JoinTable(
            name = "passenger_activities",
            joinColumns = @JoinColumn(name = "passenger_name"),
            inverseJoinColumns = @JoinColumn(name = "activity_name")
    )
    private List<Activity> activities;

}
