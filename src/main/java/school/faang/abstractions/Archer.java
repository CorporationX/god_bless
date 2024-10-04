package school.faang.abstractions;

public class Archer extends Character {
    private static final int POWER_DEFAULT = 3;
    private static final int SKILL_DEFAULT = 10;
    private static final int INTELLIGENCE_DEFAULT = 5;

    public Archer(String name) {
        super(name, POWER_DEFAULT, SKILL_DEFAULT, INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.skill;
    }
}
