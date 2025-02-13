package school.faang;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var characters = new Character[] {
                new Warrior("Alex"),
                new Warrior("Ivan"),
                new Archer("Masha"),
                new Archer("Kate"),
                new Archer("Ann"),
                new Warrior("Pavel"),
        };

        System.out.printf("Characters: %s%n", formatCharacters(characters, false));

        runGame(characters);
    }

    private static void runGame(Character[] characters) {
        var rnd = new Random();

        // Битва до момента, пока не останется 1 игрок
        // Ситуацию, когда все мертвы изначально не рассматриваем
        var winnerIndex = -1;
        do {
            var attacker = getFirstAliveCharacter(characters, rnd);
            var attacked = getFirstAliveCharacter(characters, rnd);
            while (attacker == attacked) {
                attacked = getFirstAliveCharacter(characters, rnd);
            }

            attacker.attack(attacked);

            System.out.printf(
                    "%s attacks %s. New health: %d%n",
                    attacker.getName(),
                    attacked.getName(),
                    attacked.getHealth());

            winnerIndex = getWinnerIndex(characters);
        }
        while (winnerIndex == -1);

        System.out.printf("Winner: %s%n", characters[winnerIndex].getName());
    }

    private static int getWinnerIndex(Character[] characters) {
        var winnerIndex = -1;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i].getHealth() > 0) {
                if (winnerIndex >= 0) {
                    // В живых больше одного персонажа
                    return -1;
                }

                winnerIndex = i;
            }
        }

        return winnerIndex;
    }

    private static Character getFirstAliveCharacter(Character[] characters, Random rnd) {
        var characterIndex = rnd.nextInt(characters.length);
        while (characters[characterIndex].isDead()) {
            characterIndex = rnd.nextInt(characters.length);
        }

        return characters[characterIndex];
    }

    private static String formatCharacters(Character[] characters, boolean onlyAlive) {
        StringBuilder result = new StringBuilder();

        for (Character character : characters) {
            if (!onlyAlive || !character.isDead()) {
                result.append(String.format(
                        "%s (%s): %d, ",
                        character.getName(),
                        character.getClass().getName(),
                        character.getHealth()));
            }
        }

        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }
}
