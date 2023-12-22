package faang.school.godbless.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(" Воспроизведение музыки");
                isPlaying = true;
            } else {
                System.out.println("Музыка воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(" Воспроизведение приостанвленно");
                isPlaying = false;
            } else {
                System.out.println("Стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Пропустить трек");
            } else {
                System.out.println("Сначала начните воспроизведение");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Запустили предыдущий трек");
            } else {
                System.out.println("Музыка не воспроизводится");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

    }
}