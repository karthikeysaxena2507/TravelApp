package travelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travelApp.entity.Destination;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageItinerary {

    private String packageName;

    private List<Destination> destinations;

}
