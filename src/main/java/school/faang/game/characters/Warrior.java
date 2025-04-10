package school.faang.game.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth() - getStrength();
        if (isAlive(opponentHealth)) {
            opponent.setHealth(opponentHealth);
        } else {
            opponent.setHealth(DEATH);
        }
    }
}