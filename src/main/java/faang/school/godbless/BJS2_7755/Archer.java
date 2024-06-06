package faang.school.godbless.BJS2_7755;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.agility = 10;
        super.intellect = 5;
    }

    public Archer(String name, int strength, int agility, int intellect) {
        this(name);
    }

    @Override
    void attack(Character character) {
        character.health -= this.agility;
    }
}
