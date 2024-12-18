package school.faang.task_49499;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private static final Logger log = LoggerFactory.getLogger(Player.class);
    private boolean isPlaying;
    private final Object lock = new Object();
    private final Playlist playlist;

    public Player(Playlist playlist) {
        this.playlist = playlist;
    }

    public void play() {
        synchronized (lock) {
            if (playlist.isEmpty()) {
                log.info("Playlist is empty");
                return;
            }
            isPlaying = true;
            playlist.getCurrentSong();
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Pausing playlist");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!playlist.isEmpty()) {
                playlist.next();
                playlist.getCurrentSong();
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!playlist.isEmpty()) {
                playlist.previous();
                playlist.getCurrentSong();
            }
        }
    }
}
