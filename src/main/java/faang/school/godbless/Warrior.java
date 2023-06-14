package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character enemy) {
        dealDamage(enemy, this.power);
    }
}
