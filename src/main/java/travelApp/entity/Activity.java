package travelApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "activities")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getActivitiesBySpaces",
                query = "SELECT * FROM activities WHERE capacity > 0;",
                resultClass = Activity.class
        )
})
@NoArgsConstructor
public class Activity {

    @Id
    @Column(name = "activity_name", nullable = false, unique = true)
    private String activityName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "capacity", nullable = false)
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "destination_name", nullable = false)
    @JsonBackReference
    private Destination destination;

    @ManyToMany(mappedBy = "activities")
    @JsonIgnore
    private List<Passenger> passengers;

}
