package school.faang.game.characters;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth() - getAgility();
        if (isAlive(opponentHealth)) {
            opponent.setHealth(opponentHealth);
        } else {
            opponent.setHealth(DEATH);
        }
    }
}