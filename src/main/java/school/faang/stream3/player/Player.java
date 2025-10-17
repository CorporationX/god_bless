package school.faang.stream3.player;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf("Начато воспроизведение музыки. Текущее состояние %b\n", isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.printf("Закончено воспроизведение музыки. Текущее состояние %b\n", isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf("Трек пропущен. Текущее состояние %b\n", isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf("Играет предыдущий трек. Текущее состояние %b\n", isPlaying);
        }
    }
}
