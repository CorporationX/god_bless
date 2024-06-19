package faang.school.godbless.pave_the_way;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private String name;
    private Location location;
    private int distanceFromWitcher;
}
