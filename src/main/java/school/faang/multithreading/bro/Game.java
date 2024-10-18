package school.faang.multithreading.bro;

import lombok.Getter;

public class Game {

  private int score;
  @Getter
  private int lives = 30;
  private final Object scoreLock = new Object();
  private final Object livesLock = new Object();

  public void update(boolean gotScore, boolean lostLife) {

    synchronized (livesLock) {
      if (lostLife) {
        System.out.println("updating lives of " + Thread.currentThread().getName());
        lives--;
        System.out.println("TOTAL LIVES (ALL PLAYERS) ------------ " + lives);
        if (lives == 0) {
          gameOver();
        }
      }
    }

    synchronized (scoreLock) {
      if (gotScore) {
        System.out.println("updating score of " + Thread.currentThread().getName());
        score++;
        System.out.println("TOTAL SCORE (ALL PLAYERS) ------------ " + score);
      }
    }
  }

  private void gameOver() {
    System.out.println("GAME OVER");
  }

}
