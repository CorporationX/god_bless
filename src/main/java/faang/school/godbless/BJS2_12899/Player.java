package faang.school.godbless.BJS2_12899;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(isPlaying + " - Играю песню");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(isPlaying + " - Песня остановилась");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(isPlaying + " - Пропускаю песню");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying)
                System.out.println(isPlaying + " - Перехожу на предыдущий трек");
        }
    }
}
