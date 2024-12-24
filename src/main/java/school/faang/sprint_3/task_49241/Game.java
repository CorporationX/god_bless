package school.faang.sprint_3.task_49241;


public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score = 0;
    private int lives = 0;

    public void update(Player player, boolean isSuccessfulTry) {
        if (!Thread.currentThread().isInterrupted()) {
            if (isSuccessfulTry) {
                synchronized (scoreLock) {
                    System.out.println(player + " successful try");
                    score++;
                    printCurrentScoreAndLives();
                }
            } else {
                synchronized (livesLock) {
                    System.out.println(player + " unsuccessful try");
                    lives++;
                    player.decreaseLives();
                    printCurrentScoreAndLives();
                    if (player.getLives() == 0) {
                        gameOver(player);
                    }
                }
            }
        }
    }

    private void gameOver(Player player) {
        System.out.println(player + " has no lives. And left the game");
        Thread.currentThread().interrupt();
    }

    private void printCurrentScoreAndLives() {
        System.out.println("Current score: " + score);
        System.out.println("Current lives: " + lives);
    }
}
