package Sprint_4_Spotify;

import lombok.AllArgsConstructor;

public class Player {
    private final Object lock = new Object();
    //замок всегда final
    private boolean isPlaying;

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            } else {
                isPlaying = false;
            }
            System.out.println(Thread.currentThread().getName() + " музыка включена: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            } else {
                isPlaying = false;
            }
            System.out.println(Thread.currentThread().getName() + " музыка выключена: " + isPlaying);
        }
    }

    // кто такой будет skip false ??
    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            } else {
                isPlaying = false;
            }
            System.out.println(Thread.currentThread().getName() + " следующий трек: " + isPlaying);
        }
    }

    // кто такой будет previous false ??
    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            } else {
                isPlaying = false;
            }
            System.out.println(Thread.currentThread().getName() + " предыдущий трек: " + isPlaying);

        }
    }
}
