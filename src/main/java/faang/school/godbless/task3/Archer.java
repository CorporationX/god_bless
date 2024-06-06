package faang.school.godbless.task3;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = this.dexterity;
        target.health -= damage;
    }
}
