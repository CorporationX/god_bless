package school.faang.bjs2_68213;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 * Задача "Абстракция, абстракция!"
 */
public class Main {
    private static final int MIN_DIE_FOR_HIT = 3;
    static final Random random = new Random();

    public static void main(String[] args) {
        var playersPool = new ArrayList<>(List.of(
                getRandomCharacter("Player One"),
                getRandomCharacter("Player Two"),
                getRandomCharacter("Player Three"),
                getRandomCharacter("Player Four"),
                getRandomCharacter("Player Five")
        ));

        killThemAll(playersPool);
    }

    public static void killThemAll(List<Character> players) {
        while (players.size() > 1) {
            try {
                for (Character attacker : players) {
                    Character target = getTargetPlayer(attacker, players);
                    String hitMessage = "Missed";

                    if (rollDie() >= MIN_DIE_FOR_HIT) {
                        attacker.attack(target);
                        hitMessage = "Hit";
                        if (target.isDie()) {
                            players.remove(target);
                            hitMessage = "Killed";
                        }
                    }

                    System.out.printf("%s attack %s! %s!%n", attacker.getName(), target.getName(), hitMessage);
                }
            } catch (ConcurrentModificationException ignored) {
                //коммент, чтобы checkstyle не ругался на пустой блок catch
            }
        }
        System.out.printf("%s wins!%n", players.get(0).getName());
    }

    public static Character getRandomCharacter(String name) {
        return rollDie() > 3 ? new Archer(name) : new Warrior(name);
    }

    public static int rollDie() {
        return random.nextInt(6) + 1;
    }

    public static Character getTargetPlayer(Character attacker, List<Character> players) {
        Character target;

        do {
            target = players.get(random.nextInt(players.size()));
        } while (attacker == target);

        return target;
    }
}
