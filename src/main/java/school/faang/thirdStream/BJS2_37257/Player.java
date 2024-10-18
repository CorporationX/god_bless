package school.faang.thirdStream.BJS2_37257;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка приостановлена");
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Включен следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включен предыдущий трек");
        }
    }
}
