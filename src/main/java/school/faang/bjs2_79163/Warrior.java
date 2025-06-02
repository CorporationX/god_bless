package school.faang.bjs2_79163;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character defender) {
        defender.setHealth(defender.getHealth() - strength);
    }
}
