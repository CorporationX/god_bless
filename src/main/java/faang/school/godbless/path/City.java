package faang.school.godbless.path;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distance;
}
