package school.faang.bjs2_58508;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, this.getAgility());
    }

}
