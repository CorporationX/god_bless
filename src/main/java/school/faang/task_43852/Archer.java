package school.faang.task_43852;

public class Archer extends Character {
    public static final int ARCHER_POWER = 3;
    public static final int ARCHER_DEXTERITY = 10;
    public static final int ARCHER_INTELLECT = 5;

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_DEXTERITY, ARCHER_INTELLECT);
    }

    @Override
    protected void attack(Character other) {
        System.out.println("Archer " + this.getName() + " attack " + other);
        other.setHealth(other.getHealth() - this.getStrength());
    }

    public String toString() {
        return "Archer " + this.getName();
    }
}
