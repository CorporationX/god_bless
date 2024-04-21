package faang.school.godbless.bro_force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (!game.isGameOver()) {
            System.out.println("Очки: " + game.getScore() + ", Жизни: " + game.getLives());
            if (!game.isGameOver()) {
                game.update();
            }
        }
    }
}
