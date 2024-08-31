package witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class Monster {
    private String name;
    private Location gps;
    private String place;
    private int power = 100;
    private int health = 1000;

    public Monster(String name, Location gps, String place) {
        this.name = name;
        this.gps = gps;
        this.place = place;
    }

}
