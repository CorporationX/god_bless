package faang.school.godbless.BJS2_12732;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Включено проигрывание треков");
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Включена пауза воспроизведения");
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Скипнули трек в плейлисте, воспроизведение следующего");
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Воспроизведение предыдущего трека");
    }
}
