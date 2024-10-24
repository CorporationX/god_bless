package Sprint_3.BJS2_36445;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private String name;
    private Location location;

    public Monster(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void displayMonster() {
        System.out.println("Monster " + name + " at (" + location.getX() + " " + location.getY() + ")");

    }

}
