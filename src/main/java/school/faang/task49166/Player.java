package school.faang.task49166;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Запуск песни");
                isPlaying = true;
            } else {
                System.out.println("Песня уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Песня приостанавливается");
                isPlaying = false;
            } else {
                System.out.println("Песня уже остановлена");
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Следующая песня");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущая песня");
        }
    }


}
