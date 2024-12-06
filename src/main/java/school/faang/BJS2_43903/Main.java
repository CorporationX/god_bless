package school.faang.BJS2_43903;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer1");
        Character warrior = new Warrior("Warrior1");


        do {
            archer.attack(warrior);
            printResult(archer.getName(), warrior.getName(), warrior.getHealth());
            warrior.attack(archer);
            printResult(warrior.getName(), archer.getName(), archer.getHealth());
        } while (archer.getHealth() > 0 && warrior.getHealth() > 0);
    }

    private static void printResult(String attacker, String opponent, double opponentHealthRemaining) {
        System.out.printf("Character %s have attacked %s resulting %s health remaining\r\n",
                attacker, opponent, opponentHealthRemaining);
    }
}
