package spotify.group.player;

import java.util.List;

public class Player {
    private final Object lock = new Object();
    private final List<Track> playlist;
    private boolean isPlaying = false;
    private int currentTrack = 0;

    public Player(List<Track> playlist) {
        this.playlist = playlist;
    }

    public void play() {
        synchronized (lock) {
            while (isPlaying) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " ожидает возможности начать воспроизведение");
                    lock.wait();
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Воспроизведение прервано");
                }
            }
            isPlaying = true;
            System.out.println(Thread.currentThread().getName()
                    + " начал воспроизведение трека. Сейчас играет: "
                    + playlist.get(currentTrack));
            lock.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            while (!isPlaying) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " ожидает начала воспроизведения, чтобы поставить на паузу.");
                    lock.wait();
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Попытка поставить на паузу прервана.");
                }
            }
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " поставил трек на паузу.");
            lock.notifyAll();
        }
    }

    public void next() {
        synchronized (lock) {
            currentTrack = (currentTrack + 1) % playlist.size();
            System.out.println(Thread.currentThread().getName()
                    + " перешел к следующему треку. Сейчас играет: "
                    + playlist.get(currentTrack));
            lock.notifyAll();
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = (currentTrack - 1 + playlist.size()) % playlist.size();
            System.out.println(Thread.currentThread().getName()
                    + " воспроизводит предыдущий трек. Сейчас играет трек: "
                    + playlist.get(currentTrack));
            lock.notifyAll();
        }
    }
}
