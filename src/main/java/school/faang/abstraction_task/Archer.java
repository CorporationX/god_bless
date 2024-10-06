package school.faang.abstraction_task;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        ability = 10;
        intellect = 5;
    }

    public Archer(String name, int strength, int ability, int intellect) {
        super(name, strength, ability, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health -= ability;
    }
}
