package faang.school.godbless;

public class Warrior extends Character {
    private final Integer POWER_WARRIOR_DEFAULT = 10;
    private final Integer AGILITY_WARRIOR_DEFAULT = 5;
    private final Integer INTELLIGENCE_WARRIOR_DEFAULT = 3;


    public Warrior(String name) {
        super(name);
        this.power = POWER_WARRIOR_DEFAULT;
        this.agility = AGILITY_WARRIOR_DEFAULT;
        this.intelligence = INTELLIGENCE_WARRIOR_DEFAULT;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - power);
    }
}
