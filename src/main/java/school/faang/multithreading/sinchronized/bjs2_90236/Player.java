package school.faang.multithreading.sinchronized.bjs2_90236;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка начала играть");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу");
            } else {
                System.out.println("Музыка уже остановлена");
            }
        }
    }

    public void skip() {
        System.out.println("Трек пропущен");
    }

    public void previous() {
        System.out.println("Вернулись к предыдущему треку");
    }
}
