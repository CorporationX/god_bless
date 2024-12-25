package school.faang.sprint3.bjs249327;

public class Player {
    private final Object lock = new Object();
    private boolean isPlayer;

    public void play() {
        synchronized (lock) {
            if (!isPlayer) {
                isPlayer = true;
                System.out.println("Музыка включена.");
            } else {
                System.out.println("[музыка уже играет!]");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlayer) {
                isPlayer = false;
                System.out.println("Музыка поставлена на паузу.");
            } else {
                System.out.println("[музыка уже стоит на паузе!]");
            }
        }
    }

    public void skip() {
        System.out.println("Трек был пропущен.");
    }

    public void previous() {
        System.out.println("Вернулись к предыдущему треку.");
    }
}