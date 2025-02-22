package school.faang;

public class Player {

    private final Object lock = new Object();
    private boolean playing = false;

    public boolean isPlaying() {
        return playing;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying()) {
                playing = true;
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка уже воспроизвоится");
            }
        }
    }


    public void pause() {
        synchronized (lock) {
            if (isPlaying()) {
                playing = false;
                System.out.println("Воспроизведение приостановлено");
            } else {
                System.out.println("Воспроизведение уже приостановлено");
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
            System.out.println("Возвращение к предыдущему треку");
        }
    }

}

