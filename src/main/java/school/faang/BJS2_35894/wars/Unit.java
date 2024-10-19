package school.faang.BJS2_35894.wars;

import lombok.Data;

@Data
public class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }
}
