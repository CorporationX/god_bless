package faang.school.godbless.task3;


public class Archer extends Character {

    private final static int POWER_ARCHER = 3;

    private final static int DEXTERITY_ARCHER = 10;

    private final static int INTELLIGENCE_ARCHER = 5;

    public void getName(String name) {
        this.name = name;
    }

    public Archer(String name) {
        super(POWER_ARCHER, DEXTERITY_ARCHER, INTELLIGENCE_ARCHER);
    }

    @Override
    public void attack(Character character) {
        int damage = this.dexterity;
        character.health = character.health - damage;
    }



}
