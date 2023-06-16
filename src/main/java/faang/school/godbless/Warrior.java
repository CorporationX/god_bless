package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - strength;
    }
}
