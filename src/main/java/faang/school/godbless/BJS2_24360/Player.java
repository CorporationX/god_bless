package faang.school.godbless.BJS2_24360;

import java.util.List;
import java.util.Random;

public class Player {

    private final Object lock = new Object();

    private boolean isPlaying;

    private final List<String> songs = List.of("Song1", "Song2", "Song3", "Song4", "Song5");
    private String currentPlayingSong= songs.get(new Random().nextInt(songs.size()));

    public void play() {
        synchronized (lock) {
            switchIsPlaying(true);
            System.out.println("Now playing: " + currentPlayingSong + ". isPlaying = " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            switchIsPlaying(false);
            System.out.println("Pause on song: " + currentPlayingSong + ". isPlaying = " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping song :" + currentPlayingSong);
            selectTrack("next");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Want to play previous song.");
            selectTrack("previous");
        }
    }

    private void selectTrack(String direction) {
        switchIsPlaying(false);
        int index;
        switch (direction) {
            case ("next") -> {
                currentPlayingSong = songs.get(
                        (index = songs.indexOf(currentPlayingSong)) == songs.size() - 1 ? 0 : index + 1
                );
            }
            case ("previous") -> {
                currentPlayingSong = songs.get(
                        (index = songs.indexOf(currentPlayingSong)) == 0 ? songs.size() - 1 : index - 1
                );
            }
            default -> throw new RuntimeException("No such direction");
        }
        System.out.println("Selected song: " + currentPlayingSong);
        switchIsPlaying(true);
        System.out.println("Now playing: " + currentPlayingSong);
    }

    private void switchIsPlaying(boolean newIsPlaying) {
        isPlaying = newIsPlaying;
        System.out.println("isPlaying is switched to " + isPlaying);
    }
}
