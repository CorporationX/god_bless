package school.faang.task_43842;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = getStrength();
        target.setHealth(target.getHealth() - damage);
        System.out.println(getName() + " (Warrior) attacked "
                + target.getName() + " and inflicts " + damage + " damage");
    }
}
