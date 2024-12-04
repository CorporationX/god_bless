package school.faang.moduleone.task_43502;

public class Warrior extends Character {
    private static final int WARRIORS_POWER = 10;
    private static final int WARRIORS_AGILITY = 5;
    private static final int WARRIORS_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIORS_POWER, WARRIORS_AGILITY, WARRIORS_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
