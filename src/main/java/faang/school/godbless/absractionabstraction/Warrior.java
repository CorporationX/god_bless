package faang.school.godbless.absractionabstraction;

public class Warrior extends Character {
    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLECT = 3;
    public Warrior(String name) {
        super(name);
        this.power = WARRIOR_POWER;
        this.agility = WARRIOR_AGILITY;
        this.intellect = WARRIOR_INTELLECT;
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.power);
    }

}
