package school.faang.solution.userSignUp.abstractTask;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int targetHp = target.getHp();
        int agility = this.getAgility();
        target.setHp(targetHp - agility);
    }
}
