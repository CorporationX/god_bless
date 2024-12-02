package school.faang.task_43807;

public class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intellect;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = 100;
    }

    public void attack(Character other) {
        System.out.println("Performing attack " + other);
    }

    @Override
    public String toString() {
        return "Character{" + "name='" + name + '\'' + ", power=" + power + ", dexterity=" + dexterity
                + ", intellect=" + intellect + ", health=" + health + '}';
    }
}
