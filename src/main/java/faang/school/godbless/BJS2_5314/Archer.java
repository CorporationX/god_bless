package faang.school.godbless.BJS2_5314;

public class Archer extends Character {

    private int strength = 3;
    private int agility = 10;
    private int intelligence = 5;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character enemy) {
        int attackPower = agility;
        enemy.health -= attackPower;
    }
}
