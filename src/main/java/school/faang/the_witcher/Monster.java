package school.faang.the_witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Monster {
    private String name;
    private Location location;

    public Monster(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
