package faang.school.godbless.multithreading.broforce;

import lombok.ToString;

@ToString
public class Game {

    private int scores;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int scores, int lives) {
        this.scores = scores;
        this.lives = lives;
    }

    public void update(Player attacker, Player defender) {
        boolean damageWillBeTakenByAttacker = Math.random() < 0.5;
        Player.getDamage(damageWillBeTakenByAttacker ? attacker : defender);

        synchronized (scoreLock) {
            scores++;
        }

        if (attacker.getLives() == 0 || defender.getLives() == 0) {
            gameOver();
        } else {
            synchronized (livesLock) {
                lives++;
            }
        }
    }

    private void gameOver() {
        System.out.println("> the game is over");
        System.out.printf("> was spent %s lives. The result score is %s%n", this.lives, this.scores);
    }

}
