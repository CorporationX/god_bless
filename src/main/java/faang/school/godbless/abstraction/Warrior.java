package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLECT = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        if (character.isAlive()) {
            character.inflictDamage(STRENGTH);
        } else {
            System.out.println(character.getName() + " is dead");
        }
    }
}
