package faang.school.godbless.witcher.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private final String name;
    private final Location location;
    private int distanceToHero;
}
