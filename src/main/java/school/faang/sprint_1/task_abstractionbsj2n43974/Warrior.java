package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 3;
    private static final int WARRIOR_AGILITY = 10;
    private static final int WARRIOR_INTELLECT = 5;

    public Warrior(String name) {
        this(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLECT);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
