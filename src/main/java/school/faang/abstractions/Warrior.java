package school.faang.abstractions;

public class Warrior extends Character {

    private static final int POWER_DEFAULT = 10;
    private static final int SKILL_DEFAULT = 5;
    private static final int INTELLIGENCE_DEFAULT = 3;

    public Warrior(String name) {
        super(name, POWER_DEFAULT, SKILL_DEFAULT, INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
    }


}
