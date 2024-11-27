package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.agility = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        target.health -= this.strength;
    }
}

