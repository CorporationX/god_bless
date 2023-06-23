package faang.school.godbless.googleMaps;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
