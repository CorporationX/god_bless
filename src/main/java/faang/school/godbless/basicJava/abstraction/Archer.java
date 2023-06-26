package faang.school.godbless.basicJava.abstraction;

public class Archer extends Character{
    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLECT = 5;

    public Archer(String name) {
        super(name);
    }

    public Archer() {
        super(POWER, AGILITY, INTELLECT);
    }

    @Override
    protected void attack(Character character) {
        if (character.health < agility) {
            character.health = 0;
            System.out.println("Противник повержен!");
        }
        else
            character.health -= agility;
    }
}
