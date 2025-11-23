package school.faang.bro_force;

import java.util.List;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        List<Player> players = List.of(
                new Player("Rambo"),
                new Player("Terminator"),
                new Player("Dutch")
        );

        GameLoop gameLoop = new GameLoop(game, players);
        gameLoop.start();
    }
}