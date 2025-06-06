package school.faang.bjs2_79157;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Character> fighters = List.of(
                new Warrior("Berserk"),
                new Warrior("Viking"),
                new Archer("Robin"),
                new Archer("Legolas")
        );

        doBattle(fighters, 10);
    }

    public static void doBattle(List<Character> fighters, int rounds) {
        System.out.println("📣 Battle started! 📣");

        for (int r = 0; r < rounds; r++) {
            System.out.println("Round " + (r + 1));

            Random random = new Random();
            int attackerIndex = random.nextInt(fighters.size());
            int opponentIndex = random.nextInt(fighters.size());

            while (attackerIndex == opponentIndex) {
                attackerIndex = random.nextInt(fighters.size());
            }

            fighters.get(attackerIndex).attack(fighters.get(opponentIndex));
        }
    }
}
