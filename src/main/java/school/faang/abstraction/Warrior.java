package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength;
        int targetHealth = target.health;
        target.health = targetHealth - damage;
        System.out.println(this.name + " attacks " + target.name + " with " + damage + " damage points");
        System.out.println(target.name + "'s health is now " + target.health + ".");
    }
}
