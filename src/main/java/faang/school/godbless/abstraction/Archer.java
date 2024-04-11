package faang.school.godbless.abstraction;

public class Archer extends Character{
    public Archer (String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }
    @Override
    public void attack(Character target) {
        int damage = this.agility;
        target.health = target.health - damage;
        System.out.println(this.name + " attack " + target.name + " with agility " + damage);
        System.out.println("Health of warrior: " + target.health);
    }
}