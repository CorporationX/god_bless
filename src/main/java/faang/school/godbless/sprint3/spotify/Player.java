package faang.school.godbless.sprint3.spotify;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Player {
    private final List<String> songs;
    private final Object lock;
    private boolean isPlaying = false;
    private int indexOfCurrentSong = 0;

    public void play() {
        if (!isPlaying) {
            synchronized (lock) {
                System.out.print("Play. ");
                printCurrentSong();
            }
            isPlaying = true;
        }
    }

    public void pause() {
        if (isPlaying) {
            synchronized (lock) {
                System.out.print("Pause. ");
                printCurrentSong();
            }
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.printf("Skipped %s%n", songs.get(indexOfCurrentSong));
            indexOfCurrentSong = (indexOfCurrentSong + 1) % songs.size();
            printCurrentSong();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.print("Previous. ");
            indexOfCurrentSong = (indexOfCurrentSong - 1 + songs.size()) % songs.size();
            printCurrentSong();
        }
    }

    private void printCurrentSong() {
        System.out.printf("Current song: %s%n", songs.get(indexOfCurrentSong));
    }
}
