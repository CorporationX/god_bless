package bjs256450;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.agility = 5;
        super.intellect = 3;
    }

    @Override
    void attack(Character opponent) {
        if (!isHealthNotLessThanZero(this)) {
            throw new IllegalArgumentException("Fighter " + this.getName() + " always killed, cannot attack");
        }
        if (isHealthNotLessThanZero(opponent)) {
            int opponentHealthAfterAttack = opponent.getHealth() - this.getStrength();
            opponent.setHealth(opponentHealthAfterAttack);
            if (!isHealthNotLessThanZero(opponent)) {
                System.out.printf("Fighter %s killed %n", opponent.getName());
            }
        }
    }
}
