package school.faang.bjs249651;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(20);

        for (int i = 0; i < 1000; i++) {
            boolean earnedPoints1 = Math.random() > 0.2;
            boolean lostLife1 = Math.random() > 0.6;
            Thread player1 = new Thread(() -> game.update(earnedPoints1, lostLife1), "Player1");
            boolean earnedPoints2 = Math.random() > 0.6;
            boolean lostLife2 = Math.random() > 0.8;
            Thread player2 = new Thread(() -> game.update(earnedPoints2, lostLife2), "Player2");
            player1.start();
            player2.start();
            try {
                player1.sleep(100);
                player2.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
