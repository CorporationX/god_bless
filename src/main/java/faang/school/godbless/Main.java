package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (game.getLives() > 0) {
            game.displayScore();
            game.displayLives();

            game.update();

        }


    }
}
