package faang.school.godbless.SpotifyBlock;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Player is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Player is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("вырубил этот не хайповый музон и врубил реально хайповый музон");
        }
    }
    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("а хотя прошлый музон был тоже достаточно хайповый");
        }
    }
}
