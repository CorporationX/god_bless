package bro_Forse;

public class Game {
    private int score = 0;
    private int lives = 3;
    private final Object scorelock = new Object();
    private final Object liveslock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scorelock) {
            if (earnedPoints) {
                score++;
                System.out.println("Points increased, current score: " + score);
            }
        }
        synchronized (liveslock) {
            if (lostLife) {
                lives--;
                System.out.println("One life lost, " + lives + " lives left");
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        if (lives == 0) {
            System.out.println("Game over with score " + score);
        }
    }

    public void startGame() {
        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;
            update(earnedPoints, lostLife);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Game not over");
            }
            if (lives == 0) {
                break;
            }
        }
    }
}
