package BJS2_12016;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distanceToCity;
}