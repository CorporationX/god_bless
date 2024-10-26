package school.faang.BJS2_37202;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Unit player1 = new Unit("Гарри", 8, game);
        Unit player2 = new Unit("Том", 5, game);

        for (int i = 0; i < 10; i++) {
            boolean earnedPoint = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.7;
            if (earnedPoint) {
                player1.earnPoint();
            }

            if (lostLife) {
                player2.loseLife();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
