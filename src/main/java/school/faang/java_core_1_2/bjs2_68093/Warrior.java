package school.faang.java_core_1_2.bjs2_68093;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, GameProperties.DEFAULT_WARRIOR_STRENGTH,
                GameProperties.DEFAULT_WARRIOR_AGILITY,
                GameProperties.DEFAULT_WARRIOR_INTELLECT);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    void attack(Character opponent) {
        opponent.reduceHealth(this.strength);
    }
}
