package school.faang.abstaction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 10, 3, 5);
    }


    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getDexterity());
    }
}
