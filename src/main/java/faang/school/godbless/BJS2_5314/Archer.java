package faang.school.godbless.BJS2_5314;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        int attackPower = getAgility();
        enemy.setHealth(enemy.health - attackPower);
    }
}