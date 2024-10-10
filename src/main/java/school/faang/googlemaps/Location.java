package school.faang.googlemaps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Location {
    private String name;
    private Double latitude;
    private Double longitude;
}
