package school.faang.googlemaps.maincode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}