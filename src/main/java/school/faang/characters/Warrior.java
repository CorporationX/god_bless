package school.faang.characters;

import school.faang.character.Character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " атакует " + opponent.getName() + " с силой " + getStrength());
        opponent.setHealth(getStrength());
    }
}