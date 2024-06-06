package faang.school.godbless.BJS2_7755;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.agility = 5;
        super.intellect = 3;
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        this(name);
    }

    @Override
    void attack(Character character) {
        character.health -= this.strength;
    }
}
