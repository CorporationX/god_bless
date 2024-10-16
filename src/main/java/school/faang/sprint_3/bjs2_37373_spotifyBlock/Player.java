package school.faang.sprint_3.bjs2_37373_spotifyBlock;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Включили музыку!");
            } else {
                System.out.println("Музыка уже играет!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Поставили музыку на паузу!");
            } else {
                System.out.println("Музыка уже на паузе!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Включаю следующий трек.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включаю предыдущий трек.");
        }
    }
}

