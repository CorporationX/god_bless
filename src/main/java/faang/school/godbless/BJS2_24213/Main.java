package faang.school.godbless.BJS2_24213;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameObject ashBrolliams = new GameObject("Ash Brolliams", 7);
        GameObject brominator = new GameObject("Brominator", 5);
        GameObject cherryBroling = new GameObject("Cherry Brolling", 8);
        game.addGameObject(ashBrolliams);
        game.addGameObject(brominator);
        game.addGameObject(cherryBroling);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<GameObject> gameObjects = game.getGameObjects();
        for (GameObject gameObject : gameObjects) {
            executorService.execute(() -> {
                while (gameObjects.stream()
                        .allMatch(gameObj -> gameObj.getLives() > 0)) {
                    game.update(gameObject);
                }
            });
        }
        executorService.shutdown();
    }
}
