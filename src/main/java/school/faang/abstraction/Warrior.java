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
        target.health -= this.strength;
        System.out.println("У "+target.name+" осталось "+target.health+" хп.");
    }
}
