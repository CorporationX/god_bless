package school.faang.bjs_49249;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicTest {

    @Test
    void startMusic() {
        Music music = new Music();
        Assertions.assertDoesNotThrow(music::startMusic);
    }
}