package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class City {
    private String name;
    private final Location location;
    private int distance;

}
