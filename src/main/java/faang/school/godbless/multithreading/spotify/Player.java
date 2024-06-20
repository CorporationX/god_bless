package faang.school.godbless.multithreading.spotify;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Player {

    private int playNow = 0; //default value

    private final List<String> playList = new ArrayList<>();

    private boolean isPlaying = false; //default value

    private final Object lock = new Object();

    public void addMusic(String song) {
        synchronized (lock) {
            playList.add(song);
            lock.notify();
        }
    }

    public void addMusic(List<String> songs) {
        synchronized (lock) {
            playList.addAll(songs);
            lock.notify();
        }
    }

    public synchronized void play() {
            isPlaying = true;
    }

    public synchronized void pause() {
            isPlaying = false;
    }

    public void skip() throws InterruptedException {
        synchronized (lock) {
            if (playList.isEmpty()) {
                lock.wait();
            }
            if (playList.size() > playNow) {
                playNow++;
            } else {
                System.out.println("Last song");
            }
        }
    }

    public synchronized void previous() throws InterruptedException {
        synchronized (lock) {
            if (playList.isEmpty()) {
                lock.wait();
            }
            if (playNow != 0) {
                playNow--;
            } else {
                System.out.println("First song");
            }
        }
    }
}
