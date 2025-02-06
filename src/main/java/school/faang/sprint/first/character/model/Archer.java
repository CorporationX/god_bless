package school.faang.sprint.first.character.model;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        int attackerAgility = this.getAgility();

        if (opponentHealth > 0) {
            opponentHealth -= attackerAgility;

            if (opponentHealth < 0) {
                opponentHealth = 0;
            }

            opponent.setHealth(opponentHealth);
        } else {
            System.out.println("Оппонент " + opponent.getName() + " повержен");
        }
    }
}
