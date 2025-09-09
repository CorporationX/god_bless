package school.faang.BJS2_85667;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getDexterity());
    }
}