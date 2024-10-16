package school.faang.task3111.creature;

import lombok.AllArgsConstructor;
import lombok.Data;
import school.faang.task3111.city.Location;
@Data
@AllArgsConstructor
public class Monster {
    private String name;
    private Location location;
}
