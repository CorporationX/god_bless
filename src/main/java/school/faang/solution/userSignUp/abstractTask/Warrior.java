package school.faang.solution.userSignUp.abstractTask;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int targetHp = target.getHp();
        int power = this.getStrength();
        target.setHp(targetHp - power);
    }
}
