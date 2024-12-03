package school.faang.tasks_43811.dota2;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 50, 5);
    }

    @Override
    protected void attacksHero(Character target) {
        useDamage(target, this.getAgility());
    }
}
