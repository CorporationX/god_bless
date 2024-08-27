package faang.school.godbless.BJS224439;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Thread player1 = new Thread(() -> {
            while (true) {
                game.update();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Player 1 interrupted");
                }
            }
        }, "Player 1");

        Thread player2 = new Thread(() -> {
            while (true) {
                game.update();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Player 2 interrupted");
                }
            }
        }, "Player 2");

        player1.start();
        player2.start();
    }
}
