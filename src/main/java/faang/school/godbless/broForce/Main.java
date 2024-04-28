package faang.school.godbless.broForce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (!game.isGameOver()) {
            game.update();
            System.out.println("Score: " + game.getScore() + ", Lives: " + game.getLives());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
