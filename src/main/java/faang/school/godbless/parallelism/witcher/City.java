package faang.school.godbless.parallelism.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private String name;
    private Location location;
    private double distanceToWitcher;
}
