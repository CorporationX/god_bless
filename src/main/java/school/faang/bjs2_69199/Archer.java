package school.faang.bjs2_69199;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 11, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
    }
}