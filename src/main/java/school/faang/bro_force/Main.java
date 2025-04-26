package school.faang.bro_force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean isScore = Math.random() < 0.5;
            boolean isLives = Math.random() < 0.3;

            game.update(isScore, isLives);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
