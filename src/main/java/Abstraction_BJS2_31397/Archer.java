package Abstraction_BJS2_31397;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Archer extends Character {
    Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " attack " + opponent.getName() + " with dexterity " + this.dexterity);
        opponent.damage(this.dexterity);
        System.out.println(opponent.getName() + " left health = " + opponent.getHealth());
    }


}