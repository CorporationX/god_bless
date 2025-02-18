package school.faang;

import lombok.Getter;
import school.faang.utils.ValidationUtil;

@Getter
public class City {
    private final String name;
    private final Location location;

    public City(String name, Location location) {
        ValidationUtil.isValidString(name, "Name");
        ValidationUtil.isValidLocation(location);
        this.name = name;
        this.location = location;
    }
}
