package school.faang.bjs2_31473;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " shoots an arrow " + target.name + " with strength: " + this.agility);
        target.health -= this.agility;
        System.out.println(target.name + " has " + target.health + " health left ");
    }
}
