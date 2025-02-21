package school.faang.googlemaps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
