package distributedArmy;

import lombok.Data;

@Data
public class Unit{
    private int power;

    Unit(int power) {
        this.power = power;
    }


}
