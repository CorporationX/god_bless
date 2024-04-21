package faang.school.godbless.withcer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class City {
    private CityName name;
    private Location location;
    private int distance;
}
