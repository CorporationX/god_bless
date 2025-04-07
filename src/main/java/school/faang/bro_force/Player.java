package school.faang.bro_force;

public class Player {
    private String name;
    private int points;
    private boolean isDead;
    private boolean isScoreChanged;
    private int lastChange;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        System.out.println("Player " + name + " joined the game");
        this.isDead = false;
        this.isScoreChanged = false;
        Game.addPlayer(this);
    }

    public String getName() {
        return name;
    }

    public int getLastChange() {
        return lastChange;
    }

    public int getPoints() {
        return points;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isScoreChanged() {
        return isScoreChanged;
    }

    public void scorePoints(int points, int timeForScoring) {
        try {
            Thread.currentThread().sleep(timeForScoring);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.points += points;
        this.lastChange = points;
        System.out.println("Player " + this.name + " scored " + points + " points");
        this.isScoreChanged = true;
        Game.lockLives.notify();
    }

    public void gameOver() {
        this.isDead = true;
        Game.lockLives.notify();
        System.out.println("Game over for the player " + this.getName());
    }
}
