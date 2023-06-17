package faang.school.godbless.abstraction;

public class Archer extends Character {

    public static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLECT = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        if (character.isAlive()) {
            character.inflictDamage(AGILITY);
        } else {
            System.out.println(character.getName() + " is dead");
        }
    }
}
