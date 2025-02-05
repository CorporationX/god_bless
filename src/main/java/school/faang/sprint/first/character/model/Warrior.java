package school.faang.sprint.first.character.model;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        int attackerPower = this.getPower();

        if (opponentHealth > 0) {
            opponentHealth -= attackerPower;

            if (opponentHealth < 0) {
                opponentHealth = 0;
            }

            opponent.setHealth(opponentHealth);
        } else {
            System.out.println("Оппонент " + opponent.getName() + " повержен");
        }
    }
}
