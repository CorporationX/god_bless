package school.faang.abstraction;

public class Archer extends Character implements Attackable{
    public Archer(String name) {
        super(3, 10, 5);
        this.setName(name);
    }

    @Override
    public void attack(Character defender) {
        defender.setHealth(defender.getHealth() - this.getAgility());
    }
}
