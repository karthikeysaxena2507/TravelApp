package travelApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "destinations")
@NoArgsConstructor
public class Destination {

    @Id
    @Column(name = "destination_name", nullable = false, unique = true)
    private String destinationName;

    @OneToMany(
            targetEntity = Activity.class,
            mappedBy = "destination",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "package_name", nullable = false)
    @JsonBackReference
    private Package packageItem;

}
