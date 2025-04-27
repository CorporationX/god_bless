package school.faang.broforce;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 100; i++) {
            boolean isScored = Math.random() < 0.6;
            boolean isLostLive = Math.random() < 0.8;
            new Thread(() -> game.update(isScored, isLostLive)).start();
        }
    }
}