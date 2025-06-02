package school.faang.bjs2_79163;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character defender) {
        defender.setHealth(defender.getHealth() - agility);
    }
}
