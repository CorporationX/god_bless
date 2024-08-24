package faang.school.godbless.BJS2_24350;

import java.util.Deque;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private Deque<String> musics;

    public Player(Deque<String> musics) {
        this.isPlaying = false;
        this.musics = musics;
    }

    public void skip() {
        synchronized (lock) {
            String skip = musics.removeLast();
            musics.addFirst(skip);
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            String prev = musics.removeFirst();
            musics.addLast(prev);
            play();
        }
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play: " + musics.peekLast());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause: " + musics.peekLast());
        }
    }
}
