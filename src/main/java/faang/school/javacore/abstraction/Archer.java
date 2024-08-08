package faang.school.javacore.abstraction;

public class Archer extends Character {

    public Archer() {
        super(3, 10, 5);
    }

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        health -= agility;
    }
}
