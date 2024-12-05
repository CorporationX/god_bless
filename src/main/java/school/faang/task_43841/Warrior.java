package school.faang.task_43841;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        if (target.getHealth() > 0) {
            System.out.println(this.name + " attacks " + target.getName() + " by force " + this.strength);
            target.health -= this.strength;
            target.checkHealth();
        } else {
            System.out.println(this.name + " cannot attack " + target.getName() + " because he is already defeated.");
        }
    }
}