package school.faang.googlemaps;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private String name;
    private Double latitude;
    private Double longitude;
}
