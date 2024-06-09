package faang.school.godbless.aged777_BSJ2_7758_abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
