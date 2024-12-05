package school.faang.task_43876;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int AQILITY = 10;
    private static final int INTELECT = 5;

    public Archer(String name) {
        super(name, POWER, AQILITY, INTELECT);
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
