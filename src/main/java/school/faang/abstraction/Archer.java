package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.health - this.agility);
        System.out.println(this.name + " attacks " + target.name + " with " + this.agility + " damage points");
        System.out.println(target.name + "'s health is now " + target.health + ".");
    }
}
