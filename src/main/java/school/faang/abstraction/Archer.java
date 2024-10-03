package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = this.agility;
        int targetHealth = target.health;
        target.health = targetHealth - damage;
        System.out.println(this.name + " attacks " + target.name + " with " + damage + " damage points");
        System.out.println(target.name + "'s health is now " + target.health + ".");
    }
}
