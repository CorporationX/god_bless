package school.faang.task_43807;

public class Warrior extends Character {
    public static final int WARRIOR_POWER = 10;
    public static final int WARRIOR_DEXTERITY = 5;
    public static final int WARRIOR_INTELLECT = 3;

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_DEXTERITY, WARRIOR_INTELLECT);
    }

    @Override
    public void attack(Character other) {
        System.out.println("Warrior attack " + other);
        other.setHealth(other.getHealth() - this.getPower());
    }
}
