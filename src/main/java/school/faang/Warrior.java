package school.faang;

public class Warrior extends Character {
    public Warrior(String name){
        super(name);
    }
    public Warrior(int strength, int ability, int intellect) {
        super(strength, ability, intellect);
    }

    @Override
    public void attack(Character archer) {
        int healthAfterAttach = archer.getHealth() - this.getStrength();
        archer.setHealth(healthAfterAttach);
    }
}
