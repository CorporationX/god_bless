package faang.school.godbless.BJS2_5314;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        int attackPower = strength;
        enemy.setHealth(enemy.health - attackPower);
    }
}