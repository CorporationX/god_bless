package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.health - this.strength);
        System.out.println(this.name + " attacks " + target.name + " with " + this.strength + " damage points");
        System.out.println(target.name + "'s health is now " + target.health + ".");
    }
}
