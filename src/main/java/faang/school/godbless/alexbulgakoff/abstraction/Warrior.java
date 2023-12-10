package faang.school.godbless.alexbulgakoff.abstraction;

/**
 * @author Alexander Bulgakov
 */
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
