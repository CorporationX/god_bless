package school.faang.bjs243903;

public class FightManager {

    public static void fight(Character character1, Character character2) {
        character1.attack(character2);
        FightManager.printResult(character1.getName(), character2.getName(), character2.getHealth());
        if (character2.getHealth() <= 0) {
            System.out.printf("Character %s Won!", character1.getName());
        } else {
            fight(character2, character1);
        }
    }

    private static void printResult(String attacker, String opponent, double opponentHealthRemaining) {
        System.out.printf("Character %s have attacked %s resulting %s health remaining\r\n",
                attacker, opponent, opponentHealthRemaining);
    }
}
