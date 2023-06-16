package faang.school.godbless.abstraction_BC_406;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public int attack(Character enemy) {
        return enemy.health -= this.power;
    }
}
