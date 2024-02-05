package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
    }

    public Archer() {
        super(3, 10, 5);
    }

    public void attack(Character character) {
        character.setHealth(character.getHealth() - getAgility());
    }
}
