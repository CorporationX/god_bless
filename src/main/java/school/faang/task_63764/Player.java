package school.faang.task_63764;

public class Player {
    private final Object lock = new Object();
    private boolean isPlayed = false;

    public void play() {
        synchronized (lock) {
            if (!isPlayed) {
                isPlayed = true;
                System.out.println("Начинает играеть музыка");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlayed) {
                isPlayed = false;
                System.out.println("Музыка поставлена на паузу");
            } else {
                System.out.println("Музыка уже стоит на паузе");
            }
        }
    }


    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку");
        }
    }
}
