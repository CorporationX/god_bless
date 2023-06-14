package task3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        dealDamage(enemy, this.power);
    }
}
