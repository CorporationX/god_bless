package faang.school.godbless.BJS224253;

public class Game {
    private int scores;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();

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
            synchronized (liveLock) {
                lives++;
            }
        }
    }

    private void gameOver() {
        System.out.println("The game is over");
        System.out.printf("Was spent %s lives. The result score is %s%n", this.lives, this.scores);
    }
}
