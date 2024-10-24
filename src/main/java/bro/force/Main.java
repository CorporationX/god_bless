package bro.force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.5;
            game.update(earnedPoints, lostLife);
        }
    }
}
