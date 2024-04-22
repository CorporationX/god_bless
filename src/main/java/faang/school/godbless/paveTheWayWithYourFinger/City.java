package faang.school.godbless.paveTheWayWithYourFinger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distance;
}
