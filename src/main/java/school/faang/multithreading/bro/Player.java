package school.faang.multithreading.bro;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class Player implements Runnable {

  private Game game;
  private int score;
  private int lives = 10;
  private boolean isAlive = true;
  private String name;

  public Player(Game game, String name) {
    this.game = game;
    this.name = name;
  }

  @Override
  public synchronized void run() {
    boolean scoreIncreased = Math.random() > 0.7;
    boolean lifeLost = Math.random() > 0.5;
    if (scoreIncreased) {
      score++;
    }

    if (lifeLost && isAlive) {
      lives--;
      System.out.println(Thread.currentThread().getName() + " lost life, now = " + lives);
      if (lives == 0) {
        System.out.println(Thread.currentThread().getName() + " [RIP]");
        this.isAlive = false;
      }
    }

    game.update(scoreIncreased, lifeLost);
  }

  @Override
  public String toString() {
    return name + ": [score] " + score + "   [lives] " + lives;
  }
}
