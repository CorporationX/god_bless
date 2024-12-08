package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Archer extends Character {
    private static final int WARRIOR_STRENGTH = 3;
    private static final int WARRIOR_AGILITY = 10;
    private static final int WARRIOR_INTELLECT = 5;

    public Archer(String name) {
        this.name = name;
        this.strength = WARRIOR_STRENGTH;
        this.agility = WARRIOR_AGILITY;
        this.intellect = WARRIOR_INTELLECT;
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}
