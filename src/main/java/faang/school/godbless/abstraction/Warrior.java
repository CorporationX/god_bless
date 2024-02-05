package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    public Warrior() {
        super(10, 5, 3);
    }

    public void attack(Character character) {
        character.setHealth(character.getHealth() - getStrength());
    }
}
