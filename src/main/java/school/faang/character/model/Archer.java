package school.faang.character.model;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        int attackerAgility = this.getAgility();

        if (opponentHealth >= attackerAgility) {
            opponent.setHealth(opponentHealth - attackerAgility);
        } else {
            System.out.println("Оппонент " + opponent.getName() + " повержен");
        }
    }
}
