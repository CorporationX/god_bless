package school.faang.broForce;

import lombok.Getter;

public class Game {
  @Getter
  private int score = 0;
  private int lives = 10;

  private final Object scoreLock = new Object();
  private final Object livesLock = new Object();

  @Getter
  private boolean gameOver = false;

  public void update(boolean isScoredPoints, boolean isLosesLife) {
    synchronized (scoreLock) {
      synchronized (livesLock) {
        if (isScoredPoints) {
          score++;
          System.out.printf("очки увеличенны -> %s\n", score);
        }

        if(isLosesLife) {
          lives--;
          System.out.printf("жизни уменьшенны -> %s\n", lives);
        }

        if(lives == 0) gameOver();
      }
    }
  }

  private void gameOver() {
    System.out.println("Game Over");
    gameOver = true;
  }
}
