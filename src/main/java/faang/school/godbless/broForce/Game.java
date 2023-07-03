package faang.school.godbless.broForce;

public class Game {
  private final Object SCORE_LOCK = new Object();
  private final Object LIVES_LOCK = new Object();
  private int score = 0;
  private int lives = 5;

  public synchronized void update() {
    synchronized (SCORE_LOCK) {
      if (lives > 0) {
        lives -= 1;
      } else {
        gameOver();
        return;
      }
    }
    synchronized (LIVES_LOCK) {
      score += 1;
    }
  }

  public void gameOver() {
    System.out.println("Game Over. Your score " + score);
  }
}
