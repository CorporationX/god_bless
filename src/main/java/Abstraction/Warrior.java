package Abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        if (this.health <= 0)
            System.out.println(this.name + " dead. Attack cannot be used");
        else if (target.getHealth() <= 0)
            System.out.println(target.getName() + " already dead");
        else {
            target.setHealth(target.getHealth() - this.strength);
            System.out.println(this.name + " dealt " + this.strength + " damage to " + target.getName());
            System.out.println(target.getName() + ": " + target.getHealth() + "HP");
        }
    }
}
