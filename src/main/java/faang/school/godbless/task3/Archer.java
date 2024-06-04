package faang.school.godbless.task3;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        int damage = dexterity;
        target.health -= damage;
    }
}
