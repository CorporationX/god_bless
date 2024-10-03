package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        int damage = this.getStrength();
        int targetHealth = target.getHealth();
        target.health = targetHealth - damage;
        System.out.println(this.getName() + " attacks " + target.getName() + " with " + damage + " damage points");
        System.out.println(target.getName() + "'s health is now " + target.getHealth() + ".");
    }
}
