package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int AGILITY = 5;
    private static final int INTELLECT = 3;

    public Warrior(String name) {
        super(name);
    }

    public Warrior() {
        super(POWER, AGILITY, INTELLECT);
    }

    @Override
    protected void attack(Character character) {
        if (character.health < power) {
            character.health = 0;
            System.out.println("Противник повержен!");
        }
        else
            character.health -= power;
    }
}
