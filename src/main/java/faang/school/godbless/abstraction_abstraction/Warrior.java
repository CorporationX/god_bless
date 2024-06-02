package faang.school.godbless.abstraction_abstraction;

public class Warrior extends Character{
    public Warrior (String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - this.strength;
    }
}
