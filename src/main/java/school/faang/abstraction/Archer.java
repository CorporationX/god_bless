package school.faang.abstraction;

import lombok.ToString;

@ToString
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent, int damage) {
        super.attack(opponent, damage);
    }

}
