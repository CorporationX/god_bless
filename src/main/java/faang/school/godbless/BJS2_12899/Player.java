package faang.school.godbless.BJS2_12899;

public class Player {
    private final Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "play";
            System.out.println(isPlaying + " - Играю песню");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "pause";
            System.out.println(isPlaying + " - Песня остановилась");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "skip";
            System.out.println(isPlaying + " - Пропускаю песню");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "previous";
            System.out.println(isPlaying + " - Перехожу на предыдущий трек");
        }
    }
}
