package school.faang.homm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Unit {

    private int power;

    public Unit(int power) {
        this.power = power;
    }
}
