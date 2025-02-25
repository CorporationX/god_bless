package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится");
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
            if (isPlaying) {
                System.out.println("Пропуск трека... Воспроизведение следующего трека.");
            } else {
                System.out.println("Пропуск трека. Воспроизведение приостановлено.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Возврат к предыдущему треку... Воспроизведение продолжается.");
            } else {
                System.out.println("Возврат к предыдущему треку. Воспроизведение приостановлено.");
            }
        }
    }
}
