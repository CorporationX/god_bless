package faang.school.godbless.BJS2_4215;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
    }

    public Archer(int strength, int agility, int intellect) {
        super(3,10,5);
    }

    public void attack(Character opponent) {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
    }

}
