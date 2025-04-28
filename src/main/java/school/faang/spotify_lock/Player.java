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

    private void changeTrack(TrackAction action) {
        int currentTrackIndex = playList.indexOf(currentTrack);
        synchronized (lock) {
            switch (action) {
                case PREVIOUS -> {
                    if (currentTrackIndex > 0) {
                        currentTrack = playList.get(currentTrackIndex - 1);
                    }
                }
                case NEXT -> {
                    if (currentTrackIndex < playList.size() - 1) {
                        currentTrack = playList.get(currentTrackIndex + 1);
                    }
                }
                default -> throw new IllegalArgumentException("Invalid track action");
            }
        }
    }

    public void play() {
        synchronized (lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing: {}", currentTrack);
            } else {
                log.info("Music is already playing...");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused: {}", currentTrack);
            } else {
                log.info("Music is already paused...");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            changeTrack(TrackAction.NEXT);
            log.info("Skipping current track. Now playing: {}", currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            changeTrack(TrackAction.PREVIOUS);
            log.info("Going back to previous track. Now playing: {}", currentTrack);
        }
    }
}