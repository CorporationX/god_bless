package faang.school.godbless;

public class Archer extends Character {
    private final Integer POWER_ARCHER_DEFAULT = 3;
    private final Integer AGILITY_ARCHER_DEFAULT = 10;
    private final Integer INTELLIGENCE_ARCHER_DEFAULT = 5;

    public Archer(String name) {
        super(name);
        this.power = POWER_ARCHER_DEFAULT;
        this.agility = AGILITY_ARCHER_DEFAULT;
        this.intelligence = INTELLIGENCE_ARCHER_DEFAULT;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - agility);
    }
}
