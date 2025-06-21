package school.faang.bjs2_82047;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> game.update(finalI % 3 > 1, finalI > 15));
            thread.start();
        }
    }
}
