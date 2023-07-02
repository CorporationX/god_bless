package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while(true){
            game.displayScore();
            game.displayLives();

            game.update();

            game.displayScore();
            game.displayLives();
        }


    }
}
