package faang.school.godbless.spotify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void mainTest() {
        Player player = new Player();

        new Thread(player::play).start();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::pause).start();

        new Thread(player::pause).start();
        new Thread(player::pause).start();

        new Thread(player::skip).start();
        new Thread(player::skip).start();

        new Thread(player::previous).start();
        new Thread(player::previous).start();
    }
}