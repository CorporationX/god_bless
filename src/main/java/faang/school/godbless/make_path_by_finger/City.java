package faang.school.godbless.make_path_by_finger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distanceToWitcher;
}
