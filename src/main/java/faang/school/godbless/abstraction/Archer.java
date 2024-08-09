package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - this.agility;
    }
}
