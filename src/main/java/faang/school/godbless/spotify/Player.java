package faang.school.godbless.spotify;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;


public class Player {
    private final int INITIAL_SONG_INDEX = 0;
    private final boolean INITIAL_IS_PLAYING_MODE = false;

    private final Object lock = new Object();
    @Getter
    @Setter
    private List<String> playlist = Arrays.asList("MusicNumberOne", "MusicNumberTwo", "MusicNumberThree");
    private boolean isPlaying;
    private int currentPlayingSongInPlaylist;

    public Player() {
        currentPlayingSongInPlaylist = INITIAL_SONG_INDEX;
        isPlaying = INITIAL_IS_PLAYING_MODE;
        System.out.println("INITIAL TURNING ON: current song " + playlist.get(currentPlayingSongInPlaylist));
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("The player is playing now");
                System.out.println("Is playing: " + isPlaying);
                System.out.println();
            } else {
                System.out.println("Playlist is already playing");
                System.out.println();
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The player on pause mode");
                System.out.println("Is playing: " + isPlaying);
                System.out.println();
            } else {
                System.out.println("Playlist is already paused");
                System.out.println();
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentPlayingSongInPlaylist++;
            currentPlayingSongInPlaylist %= playlist.size();
            System.out.println("Change to NEXT song. Current song name " + playlist.get(currentPlayingSongInPlaylist));
            System.out.println("Is playing: " + isPlaying);
            System.out.println();
        }
    }

    public void previous() {
        synchronized (lock) {
            currentPlayingSongInPlaylist += playlist.size();
            currentPlayingSongInPlaylist--;
            currentPlayingSongInPlaylist %= playlist.size();
            System.out.println("Change to PREVIOUS song. Current song name " + playlist.get(currentPlayingSongInPlaylist));
            System.out.println("Is playing: " + isPlaying);
            System.out.println();
        }
    }
}
