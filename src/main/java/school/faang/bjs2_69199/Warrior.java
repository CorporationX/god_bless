package school.faang.bjs2_69199;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 9, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}