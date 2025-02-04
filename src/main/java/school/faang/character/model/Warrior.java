package school.faang.character.model;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int opponentHealth = opponent.getHealth();
        int attackerPower = this.getPower();

        if (opponentHealth >= attackerPower) {
            opponent.setHealth(opponentHealth - attackerPower);
        } else {
            System.out.println("Оппонент " + opponent.getName() + " повержен");
        }
    }
}
