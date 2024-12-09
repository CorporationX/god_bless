package school.faang.sprint1.task_bjs243889;

public class Main {

    public static final String DEAD_MESSAGE = " пал смертью храбрых";
    public static final String WARRIOR_HEALTH_MESSAGE = "У война остаётся здоровья: ";
    public static final String ARCHER_HEALTH_MESSAGE = "У лучника остаётся здоровья: ";

    public static void main(String[] args) {
        var archer = new Archer("Petr");
        var warrior = new Warrior("Mihail");

        for (int i = 0; i < 10; i++) {
            attackerSetDamageToOpponent(archer, warrior, WARRIOR_HEALTH_MESSAGE);
            attackerSetDamageToOpponent(warrior, archer, ARCHER_HEALTH_MESSAGE);
        }
    }

    private static void attackerSetDamageToOpponent(Character attacker, Character opponent, String healthMessage) {
        if (attacker.getHealth() > 0) {
            attacker.attack(opponent);
            printHealth(opponent, healthMessage);
        } else {
            System.out.println(attacker.getName() + DEAD_MESSAGE);
        }
    }

    private static void printHealth(Character character, String healthMessage) {
        System.out.println(healthMessage + character.getHealth());
    }

}
