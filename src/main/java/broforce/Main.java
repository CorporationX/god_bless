package broforce;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Runnable playerAction = () -> {
            for (int i = 0; i < 20; i++) {
                boolean isScored = Math.random() < 0.5;
                boolean isLifeLost = Math.random() < 0.3;

                game.update(isScored, isLifeLost);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread player1 = new Thread(playerAction, "Player-1");
        player1.start();

        Thread player2 = new Thread(playerAction, "Player-2");
        player2.start();

        Thread player3 = new Thread(playerAction, "Player-3");
        player3.start();

        Thread player4 = new Thread(playerAction, "Player-4");
        player4.start();

        Thread player5 = new Thread(playerAction, "Player-5");
        player5.start();
    }
}
