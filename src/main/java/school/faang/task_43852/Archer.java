package school.faang.task_43852;

public class Archer extends Character {

    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_DEXTERITY = 10;
    private static final int ARCHER_INTELLECT = 5;

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_DEXTERITY, ARCHER_INTELLECT);
    }

    @Override
    protected void attack(Character other) {
        System.out.println("Archer " + getName() + " attacks " + other.getName());
        other.setHealth(Math.max(0, other.getHealth() - getStrength()));
    }

    @Override
    public String toString() {
        return "Archer " + getName();
    }
}
