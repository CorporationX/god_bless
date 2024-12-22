package school.faang.sprint_3.task_49241;


public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score = 0;
    private int lives = 0;

    public void update(Player player, boolean isSuccessfulTry) {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (isSuccessfulTry) {
                    score++;
                } else {
                    lives++;
                    player.decreaseLives();
                }
                System.out.println("Current score: " + score);
                System.out.println("Current lives: " + lives);
            }
        }
    }
}
