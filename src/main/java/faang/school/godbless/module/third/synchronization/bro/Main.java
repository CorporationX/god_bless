package faang.school.godbless.module.third.synchronization.bro;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(5);
        Runnable runnable = () -> {
            while (!game.isGameOver()) {
                game.update();
            }
        };
        Thread player1 = new Thread(runnable);
        Thread player2 = new Thread(runnable);
        player1.start();
        player2.start();
    }
}
