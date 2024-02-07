package faang.school.godbless.java_core.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5 ,3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);
    }
}
