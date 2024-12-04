package school.faang.task_43869;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, Integer strength, Integer agility, Integer intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.strength);
    }
}