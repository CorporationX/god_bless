package heroArmy_1003;

import lombok.Data;

@Data
public class Unit {
    private int power;
    private String name;

    public Unit(int power, String name) {
        this.power = power;
        this.name = name;
    }
}
