package school.faang.supercow;

import java.util.Arrays;
import java.util.List;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> players = Arrays.asList(
                new Player("Игрок 1"),
                new Player("Игрок 2"),
                new Player("Игрок 3"),
                new Player("Игрок 4")
        );

        players.stream()
                .map(player -> new Thread(() -> player.doBattle(boss)))
                .forEach(Thread::start);
    }
}