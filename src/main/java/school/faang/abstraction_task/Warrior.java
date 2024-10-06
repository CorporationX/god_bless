package school.faang.abstraction_task;

public class Warrior extends Character {


    public Warrior(String name) {
        super(name);
        strength = 10;
        ability = 5;
        intellect = 3;
    }

    public Warrior(String name, int strength, int ability, int intellect) {
        super(name, strength, ability, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health -= strength;
    }
}
