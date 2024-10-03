package school.faang.abstraction;

public class Archer extends Warrior {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        int damage = this.getAgility();
        int targetHealth = target.getHealth();
        target.health = targetHealth - damage;
        System.out.println(this.getName() + " attacks " + target.getName() + " with " + damage + " damage points");
        System.out.println(target.getName() + "'s health is now " + target.getHealth() + ".");
    }
}
