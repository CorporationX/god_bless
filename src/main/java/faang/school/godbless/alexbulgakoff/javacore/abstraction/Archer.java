package faang.school.godbless.alexbulgakoff.javacore.abstraction;

/**
 * @author Alexander Bulgakov
 */
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }

}
