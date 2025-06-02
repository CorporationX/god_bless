package school.faang.bjs2_79157;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character war1 = new Warrior("Berserk");
        Character war2 = new Warrior("Viking");
        Character arch1 = new Archer("Robin");
        Character arch2 = new Archer("Legolas");

        Character[] fighters = {war1, war2, arch1, arch2};

        doBattle(fighters, 10);
    }

    public static void doBattle(Character[] fighters, int rounds) {
        System.out.println("📣 Battle started! 📣");

        for (int r = 0; r < rounds; r++) {
            System.out.println("Round " + (r + 1));

            Random random = new Random();
            int attackerIndex = random.nextInt(fighters.length);
            int opponentIndex = random.nextInt(fighters.length);

            //prevent attacking self
            while (attackerIndex == opponentIndex) {
                attackerIndex = random.nextInt(fighters.length);
            }

            fighters[attackerIndex].attack(fighters[opponentIndex]);
        }
    }
}
