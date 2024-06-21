package faang.school.godbless.domain.task_spotify;

public class Player {
    private Lock lock = new Lock();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("воспроизведение началось");
                isPlaying = false;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("воспроизведение приостановлено");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("пропущен трек");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("предыдущий трек");
            }
        }
    }
}


