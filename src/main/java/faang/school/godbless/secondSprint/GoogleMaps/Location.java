package faang.school.godbless.secondSprint.GoogleMaps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
