package faang.school.javacore.abstraction;

public class Warrior extends Character {

    public Warrior() {
        super(10, 5, 3);
    }

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        health -= strength;
    }
}
