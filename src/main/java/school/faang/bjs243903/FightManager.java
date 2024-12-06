package school.faang.bjs243903;

public class FightManager {

    public static void fight(Character character1, Character character2) {
        character1.attack(character2);
        FightManager.printResult(character1.getName(), character2.getName(), character2.getHealth());
        if (character2.getHealth() > 0)  {
            fight(character2, character1);
        }
    }

    public static void fight(Character character1, Character character2, boolean useLoop) {

        do {
            character1.attack(character2);
            FightManager.printResult(character1.getName(), character2.getName(), character2.getHealth());
            if (character2.getHealth() <= 0) {
                return;
            }
            character2.attack(character1);
            FightManager.printResult(character2.getName(), character1.getName(), character1.getHealth());

        } while (character1.getHealth() > 0 && character2.getHealth() > 0);
    }

    private static void printResult(String attacker, String opponent, double opponentHealthRemaining) {
        System.out.printf("Character %s have attacked %s resulting %s health remaining\r\n",
                attacker, opponent, opponentHealthRemaining);

        if (opponentHealthRemaining <= 0) {
            System.out.printf("Character %s Won!", attacker);
        }
    }
}
