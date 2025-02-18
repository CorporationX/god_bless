package school.faang;

import lombok.Getter;
import school.faang.utils.ValidationUtil;

@Getter
public class Monster {
    private final String name;
    private final Location location;

    public Monster(String name, Location location) {
        ValidationUtil.isValidString(name, "Name");
        ValidationUtil.isValidLocation(location);
        this.name = name;
        this.location = location;
    }
}
