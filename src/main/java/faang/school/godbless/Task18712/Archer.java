package faang.school.godbless.Task18712;

public class Archer extends Character{


    public Archer(String name) {
        super(name, 3, 10,5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getStrength();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
