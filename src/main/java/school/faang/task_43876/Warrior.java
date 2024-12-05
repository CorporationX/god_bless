package school.faang.task_43876;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int AQILITY = 5;
    private static final int INTELECT = 3;

    public Warrior(String name) {
        super(name, POWER, AQILITY, INTELECT);
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
