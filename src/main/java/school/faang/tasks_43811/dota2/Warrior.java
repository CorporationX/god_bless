package school.faang.tasks_43811.dota2;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 12, 5, 3);
    }

    @Override
    protected void attacksHero(Character target) {
        useDamage(target, this.getStrength());
    }
}
