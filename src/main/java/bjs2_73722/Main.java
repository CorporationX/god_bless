package bjs2_73722;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean changingScore = Math.random() > 0.5;
            boolean changingLives = Math.random() < 0.5;

            game.update(changingScore, changingLives);
        }
    }
}
