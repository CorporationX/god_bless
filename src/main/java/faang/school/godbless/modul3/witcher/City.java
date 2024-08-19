package faang.school.godbless.modul3.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distanceToWitcher;
}
