package bjs256450;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.agility = 10;
        super.intellect = 5;
    }

    @Override
    void attack(Character opponent) {
        if (!isHealthNotLessThanZero(this)) {
            throw new IllegalArgumentException("Fighter " + this.getName() + " always killed, cannot attack");
        }
        if (isHealthNotLessThanZero(opponent)) {
            int opponentHealthAfterAttack = opponent.getHealth() - this.getAgility();
            opponent.setHealth(opponentHealthAfterAttack);
            if (!isHealthNotLessThanZero(opponent)) {
                System.out.printf("Fighter %s killed %n", opponent.getName());
            }
        }
    }
}

