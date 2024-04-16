package faang.school.godbless.BJS2_5522;

public class Player {
    private final Object LOCK = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (LOCK) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(isPlaying);
            }
        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(isPlaying);
            }
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Включена следующая композиция");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("Включена предыдущая композиция");
        }
    }
}
