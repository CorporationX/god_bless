package school.faang.moduleone.task_43502;

public class Archer extends Character {
    private static final int ARCHERS_POWER = 3;
    private static final int ARCHERS_AGILITY = 10;
    private static final int ARCHERS_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHERS_POWER, ARCHERS_AGILITY, ARCHERS_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}
