package distributed_army_of_heroes_of_might_andmagic;

import lombok.Getter;

@Getter

public class Unit {
    private int power;
    public Unit(int power){
        this.power = power;
    }
}
