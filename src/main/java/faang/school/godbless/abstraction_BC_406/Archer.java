package faang.school.godbless.abstraction_BC_406;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public int attack(Character enemy) {
        return enemy.health -= this.agility;
    }
}
