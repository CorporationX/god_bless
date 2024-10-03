package school.faang;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        target.health -= this.agility;
        System.out.println("У "+target.name+" осталось "+target.health+" хп.");
    }
}
