package school.faang.bjs_49299;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void gameStart() {
        GameService gameService = new GameService();
        Assertions.assertDoesNotThrow(gameService::gameStart);
    }
}