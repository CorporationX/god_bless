package Abstraction_BJS2_31397;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Warrior extends Character {

    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " attack " + opponent.getName() + " with power " + this.power);
        opponent.damage(this.power);
        System.out.println(opponent.getName() + " left health = " + opponent.getHealth());

    }

}