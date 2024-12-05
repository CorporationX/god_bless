package school.faang.task_43841;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        if (target.getHealth() > 0) {
            System.out.println(this.name + " shoots at " + target.getName() + " with dexterity " + this.agility);
            target.health -= this.agility;
            target.checkHealth();
        } else {
            System.out.println(this.name + " cannot attack " + target.getName() + " because he is already defeated.");
        }
    }
}