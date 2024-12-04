package school.faang.task_43848;

public class Archer extends Character {
    protected static final int STRENGTH = 10;
    protected static final int AGILITY = 5;
    protected static final int INTELLIGENCE = 3;

    public Archer(String name) {
        super(name);
        this.strength = STRENGTH;
        this.agility = AGILITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.println(this.getClass().getSimpleName() + " attacks " + defender.getClass().getSimpleName());
        defender.setHealth(defender.getHealth() - this.agility);
    }
}
