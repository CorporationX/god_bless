package BJS261664;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean points = Math.random() > 0.5;
            boolean lives = Math.random() > 0.83;

            game.update(points, lives);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
