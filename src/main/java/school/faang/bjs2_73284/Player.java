package school.faang.bjs2_73284;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка уже играет");
            } else {
                System.out.println("Музыка начинает играть");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Музыка на паузе");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Следующий трек");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трек");
            isPlaying = true;
        }
    }
}
