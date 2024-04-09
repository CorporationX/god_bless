package Abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        if (this.health <= 0)
            System.out.println(this.name + " dead. Attack cannot be used");
        else if (target.getHealth() <= 0)
            System.out.println(target.getName() + " already dead");
        else {
            target.setHealth(target.getHealth() - this.agility);
            System.out.println(this.name + " dealt " + this.agility + " damage to " + target.getName());
            System.out.println(target.getName() + ": " + target.getHealth() + "HP");
        }
    }
}
