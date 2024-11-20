package school.faang.synchronizedthreads1;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 10; i++) {
            boolean scoreIncrease = (i % 2 == 0);
            boolean lifeLost = (i % 3 == 0);
            game.update(scoreIncrease, lifeLost);


            if (game.getLives() <= 0) {
                break;
            }
        }
    }
}
