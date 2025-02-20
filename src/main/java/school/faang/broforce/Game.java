package school.faang.broforce;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update() {
        synchronized (scoreLock,livesLock){

        }
    }
}
