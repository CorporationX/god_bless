package faang.school.godbless.finger_path;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {

    private String name;
    private Location location;
    private int distance;
}
