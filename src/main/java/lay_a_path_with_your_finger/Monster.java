package lay_a_path_with_your_finger;

import lombok.Data;

@Data
public class Monster {
    private String name;
    private Location location;
    private double distanceFromCity = 0.0;

    public Monster(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
