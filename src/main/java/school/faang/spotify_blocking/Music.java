package school.faang.spotify_blocking;

import java.util.Arrays;
import java.util.List;

/**
 * Проект: god_bless
 * Класс Music
 * Автор: Vital
 */

public class Music {

    private final Player player;

    public Music(Player player) {
        this.player = player;
    }

    public void startSessions() {
        //список действий, которые будут выполняться в потоках
        List<Runnable> actions = Arrays.asList(
                player::play,
                player::pause,
                player::skip,
                player::previous,
                player::play,
                player::skip
        );

        actions.stream()
                .map(Thread::new)
                .forEach(Thread::start);
    }
}