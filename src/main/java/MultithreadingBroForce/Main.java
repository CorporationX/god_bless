package MultithreadingBroForce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 50; i++) {
            boolean scoresEarned = Math.random() > 0.5;
            boolean livesLost = Math.random() > 0.7;

            try {
                game.update(scoresEarned, livesLost);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
