package school.faang.bjs2_58508;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, this.getStrength());
    }

}
