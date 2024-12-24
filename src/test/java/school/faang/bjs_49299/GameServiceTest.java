package school.faang.bjs_49299;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void gameStart() {
        int startScore = 0;
        int startLives = 50;
        Game game = new Game(startScore, startLives);
        GameService gameService = new GameService(game);

        Assertions.assertEquals(0, game.getScore());
        Assertions.assertEquals(50, game.getLives());

        gameService.gameStart();

        Assertions.assertFalse(game.isRunning());
        Assertions.assertEquals(0, game.getLives());
        Assertions.assertTrue(game.getScore() > 0);
    }
}