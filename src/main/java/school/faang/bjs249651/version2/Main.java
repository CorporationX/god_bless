package school.faang.bjs249651.version2;

public class Main {

    public static void main(String[] args) {
        Game2 game = new Game2(20);
        Player parvin = new Player("Parvin");
        Player narmin = new Player("Narmin");

        while (!game.isGameOver()) {
            boolean earnedPoints1 = Math.random() > 0.2;
            boolean lostLife1 = Math.random() > 0.6;
            parvin.setEarnedPoint(earnedPoints1);
            parvin.setLostLife(lostLife1);
            Thread player1 = new Thread(() -> game.update(parvin), "Parvin");

            boolean earnedPoints2 = Math.random() > 0.6;
            boolean lostLife2 = Math.random() > 0.8;
            narmin.setEarnedPoint(earnedPoints2);
            narmin.setLostLife(lostLife2);
            Thread player2 = new Thread(() -> game.update(narmin), "Narmin");

            player1.start();
            player2.start();
            try {
                player1.sleep(100);
                player2.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(parvin);
        System.out.println(narmin);
    }

}
