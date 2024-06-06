package faang.school.godbless;


public class Warrior extends Character {

    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);

    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - getStrength());
    }

}
