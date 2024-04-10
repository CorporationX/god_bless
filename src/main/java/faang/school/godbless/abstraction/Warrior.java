package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 15;
        this.agility = 5;
        this.intelligence = 3;
    }
    @Override
    public void attack(Character target) {
        int damage = this.strength;
        target.health = target.health - damage;
        System.out.println(this.name + " attack " + target.name + " with strength " + damage);
        System.out.println("Health of archer: " + target.health);
    }
}