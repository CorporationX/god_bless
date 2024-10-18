package bro_force;

public class Game {
    private int score = 0;
    private int lives = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    /**
     * Updates the game state based on the game events.
     *
     * <p>If the player scored, increments the score and prints the updated score.
     * If the player lost a life, decrements the lives and prints the updated lives.
     * If the lives reaches zero, calls the {@link #gameOver()} method to end the game.
     *
     * @param playerScored   whether the player scored in this iteration
     * @param playerLostLife whether the player lost a life in this iteration
     */
    public void update(boolean playerScored, boolean playerLostLife) {
        if (playerScored) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Игрок набрал очки. Текущий счет: " + score);
            }
        }
        if (playerLostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println("Игрок потерял жизнь. Осталось жизней: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    /**
     * Called when the player loses all lives.
     * Prints the current score and lives,
     * and then terminates the program.
     */
    private void gameOver() {
        System.out.println("Game over!\n");
        System.out.println("Score: " + score);
        System.out.println("Lives: " + lives);
        System.exit(0);
    }

    /**
     * The main entry point of the game. Creates a new instance of the game and
     * runs it for 10 iterations. In each iteration, the player has a 50%
     * chance of scoring and a 30% chance of losing a life. The game is paused
     * for 500 milliseconds after each iteration.
     *
     * @param args The command line arguments, ignored.
     */
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            boolean playerScored = Math.random() > 0.5;
            boolean playerLostLife = Math.random() > 0.7;

            game.update(playerScored, playerLostLife);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
