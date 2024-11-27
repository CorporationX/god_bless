package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.agility = 8;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        target.health -= this.agility;
    }
}
