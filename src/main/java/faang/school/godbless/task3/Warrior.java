package faang.school.godbless.task3;


public class Warrior extends Character {

    private final static int POWER_WARRIOR = 10;

    private final static int DEXTERITY_WARRIOR = 5;

    private final static int INTELLIGENCE_WARRIOR = 3;

    public Warrior(String name) {
        super(POWER_WARRIOR, DEXTERITY_WARRIOR, INTELLIGENCE_WARRIOR);
    }

    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.health = character.health - damage;
    }


}
