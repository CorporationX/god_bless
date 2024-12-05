package school.module1.task43832;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    Warrior(String name, int strength, int dexterity, int intelligence) {
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
        if (character.getHealth() < DEFAULT_STRENGTH) {
            character.setHealth(0);
        } else {
            character.setHealth(character.getHealth() - character.getDexterity());
        }
    }
}
