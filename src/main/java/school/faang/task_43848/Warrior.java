package school.faang.task_43848;

public class Warrior extends Character {
    protected final int STRENGTH = 10;
    protected final int AGILITY = 5;
    protected final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        this.strength = STRENGTH;
        this.agility = AGILITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.println(this.getClass().getSimpleName() + " attacks " + defender.getClass().getSimpleName());
        defender.setHealth(defender.getHealth() - this.strength);
    }
}
