package school.module1.task43832;

public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    void attack(Character character) {
        if (!isAlive()) {
            System.out.println("Мертв");
            return;
        }
        if (character.getHealth() < 10) {
            character.setHealth(0);
        } else {
            character.setHealth(character.getHealth() - character.getDexterity());
        }
    }
}
