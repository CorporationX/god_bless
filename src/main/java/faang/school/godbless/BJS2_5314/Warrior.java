package faang.school.godbless.BJS2_5314;

public class Warrior extends Character {

    private int strength = 10;
    private int agility = 5;
    private int intelligence = 3;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character enemy) {
        int attackPower = strength;
        enemy.health -= attackPower;
    }
}
