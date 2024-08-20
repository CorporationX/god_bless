package faang.school.godbless.finger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distanceToWitcher;
    private final int beautifulWomenCount;
}
