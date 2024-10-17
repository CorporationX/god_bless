package bjs2_37100;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 15);

        while (game.isPlaying()) {
            game.update();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
