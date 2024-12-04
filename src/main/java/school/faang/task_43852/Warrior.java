package school.faang.task_43852;

public class Warrior extends Character {

    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_DEXTERITY = 5;
    private static final int WARRIOR_INTELLECT = 5;


    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_DEXTERITY, WARRIOR_INTELLECT);

    }


    @Override
    protected void attack(Character other) {
        System.out.println("Warrior " + this.getName()
                + " attack " + other);
        other.setHealth(other.getHealth() - this.getStrength());

    }

    public String toString() {
        return "Warrior " + this.getName();
    }
}
