package school.faang;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.8;
            game.update(earnedPoints, lostLife);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep was interrupted.");
                throw new RuntimeException(e);
            }
        }
    }
}
