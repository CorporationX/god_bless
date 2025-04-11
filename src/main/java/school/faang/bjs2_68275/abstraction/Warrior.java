package school.faang.bjs2_68275.abstraction;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        if (isHealthLessZeroAfterAttack(opponent.health, this.strength)) {
            opponent.health = 0;
        } else {
            opponent.health -= this.strength;
        }
    }
}
