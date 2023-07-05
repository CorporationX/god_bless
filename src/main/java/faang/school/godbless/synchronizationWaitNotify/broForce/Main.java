package faang.school.godbless.synchronizationWaitNotify.broForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        Game game = new Game();
        List<Character> characterList = List.of(
                new Character("Bob", 0, 5),
                new Character("Elza", 0, 4),
                new Character("Alex", 0, 9),
                new Character("Tom", 0, 6),
                new Character("Term", 0, 2)
        );

        characterList.forEach(game::addCharacter);

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < game.getCharacters().size(); i++) {
            executorService.execute(() -> {
                while (!game.isOver()) {
                    game.update();
                }
            });
        }

        executorService.shutdown();
    }
}
