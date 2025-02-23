package school.faang.BJS2_61703;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                game.update();
            }).start();
        }
    }
}
