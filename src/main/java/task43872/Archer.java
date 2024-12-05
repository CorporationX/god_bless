package task43872;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character target) {
        target.reduceHealth(this.agility);
        System.out.println(this.name + " attack " + target.name + " and applies " + this.agility + " damage. ");
    }

}
