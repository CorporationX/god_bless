package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Warrior extends Character{
    private final static int WARRIOR_STRENGTH = 10;
    private final static int WARRIOR_AGILITY = 5;
    private final static int WARRIOR_INTELLECT = 3;

    public Warrior(String name) {
        super(name);
        this.strength = WARRIOR_STRENGTH;
        this.agility = WARRIOR_AGILITY;
        this.intellect = WARRIOR_INTELLECT;
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name);
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
