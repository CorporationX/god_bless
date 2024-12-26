package school.faang.task_49368;

public class Player {

    private final Object playerLock;

    private boolean isPlaying = false;

    public Player() {
        playerLock = new Object();
    }

    public void play() {
        synchronized (playerLock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("--- музыка играет --- ");
            } else {
                System.out.println("--- музыка УЖЕ играет ---");
            }
        }
    }

    public void pause() {
        synchronized (playerLock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("--- поставлено на паузу ---");
            } else {
                System.out.println("--- музыка УЖЕ на паузе ---");
            }
        }
    }

    public void skip() {
        synchronized (playerLock) {
            System.out.println("--- трек пропущен ---");
        }
    }

    public void previous() {
        synchronized (playerLock) {
            System.out.println("--- предыдущий трек ---");
        }
    }
}
