package school.faang.broforce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3);
        while (!game.getIsGameOver()) {
            game.update();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game finished. Final score: " + game.getScore());
    }
}
