package school.faang.bjs2_31473;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.name + " with strength: " + this.strength);
        target.health -= this.strength;
        System.out.println(target.name + " has " + target.health + " health left ");
    }
}
