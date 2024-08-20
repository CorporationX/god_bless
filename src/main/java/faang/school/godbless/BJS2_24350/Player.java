package faang.school.godbless.BJS2_24350;

import java.util.Deque;

public class Player {
    private boolean isPlaying;
    private Deque<String> musics;

    public Player(Deque<String> musics) {
        this.isPlaying = false;
        this.musics = musics;
    }

    public synchronized void skip() {
        String skip = musics.removeLast();
        musics.addFirst(skip);
        play();
    }

    public synchronized void previous() {
        String prev = musics.removeFirst();
        musics.addLast(prev);
        play();
    }

    public synchronized void play() {
        isPlaying = true;
        System.out.println("Play: " + musics.peekLast());
    }

    public synchronized void pause() {
        isPlaying = false;
        System.out.println("Pause: " + musics.peekLast());
    }
}
