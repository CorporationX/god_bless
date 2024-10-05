package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int strength, int ability, int intellect) {
        super(strength, ability, intellect);
    }

    @Override
    public void attack(Character archer) {
        int healthAfterAttach = archer.getHealth() - this.getAbility();
        archer.setHealth(healthAfterAttach);
    }
}
