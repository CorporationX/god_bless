package school.BJS2_37236;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                this.isPlaying = true;
                System.out.println("Музыка начала играть.");
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
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаем трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трек");
        }
    }
}