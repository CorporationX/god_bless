package school.faang.bjs249511;

public class Player {

    public final Object lock = new Object();
    public boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку.");
        }
    }
}
