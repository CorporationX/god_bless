package school.faang.spotify_lock;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private String currentTrack = "Ed Sheeran - Shape of You";
    private final List<String> playList = List.of(
            "Ed Sheeran - Shape of You",
            "The Weeknd - Blinding Lights",
            "Adele - Someone Like You",
            "Queen - Bohemian Rhapsody",
            "Michael Jackson - Billie Jean",
            "Oasis - Wonderwall",
            "Eminem - Lose Yourself",
            "Adele - Rolling in the Deep",
            "Bruno Mars - Uptown Funk",
            "Nirvana - Smells Like Teen Spirit"
    );

    public void trackAction(TrackAction action) {
        switch (action) {
            case PLAY -> play();
            case PAUSE -> pause();
            case SKIP -> skip();
            case PREVIOUS -> previous();
            default -> throw new IllegalArgumentException("Invalid track action");

        }
    }

    private void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing: {}", currentTrack);
            } else {
                log.info("Music is already playing...");
            }
        }
    }

    private void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused: {}", currentTrack);
            } else {
                log.info("Music is already paused...");
            }
        }
    }

    private void skip() {
        synchronized (lock) {
            int currentTrackIndex = playList.indexOf(currentTrack);
            if (currentTrackIndex < playList.size() - 1) {
                currentTrack = playList.get(currentTrackIndex + 1);
            } else {
                currentTrack = playList.get(0);
            }
            log.info("Skipping current track. Now playing: {}", currentTrack);
        }
    }

    private void previous() {
        synchronized (lock) {
            int currentTrackIndex = playList.indexOf(currentTrack);
            if (currentTrackIndex > 0) {
                currentTrack = playList.get(currentTrackIndex - 1);
            } else {
                currentTrack = playList.get(playList.size() - 1);
            }
            log.info("Going back to previous track. Now playing: {}", currentTrack);
        }
    }
}