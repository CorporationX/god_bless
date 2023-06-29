package faang.school.godbless.Sprint2;

public class Archer extends Character{

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.health = target.health - dexterity;
    }
}
