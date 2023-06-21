package faang.school.godbless.sprint2.googleMaps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
@Value
public class Location {
    String name;
    double latitude;
    double longitude;
}
