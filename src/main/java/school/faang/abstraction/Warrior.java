package school.faang.abstraction;

import lombok.ToString;

@ToString
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent, int damage) {
        super.attack(opponent, damage);
    }

}
