package school.faang.googlemaps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
