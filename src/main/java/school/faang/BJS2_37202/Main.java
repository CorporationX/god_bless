package school.faang.BJS2_37202;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Unit player1 = new Unit("Гарри", 8, game);
        Unit player2 = new Unit("Том", 5, game);

        for (int i = 0; i < 10; i++) {
            boolean earnedPoint1 = Math.random() < 0.5;
            boolean earnedPoint2 = Math.random() < 0.5;
            boolean lostLife1 = Math.random() < 0.7;
            boolean lostLife2 = Math.random() < 0.7;

            if (earnedPoint1) {
                player1.earnPoint();
            }
            if (earnedPoint2) {
                player2.earnPoint();
            }
            if (lostLife1) {
                player1.loseLife();
            }
            if (lostLife2) {
                player2.loseLife();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (game.isGameOver()) {
                break;
            }
        }
    }
}
