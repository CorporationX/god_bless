package faang.school.godbless.thirdSprint.BroForce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Thread thread1 = new Thread(() -> {
            while (game.isGameContinues()) {
                game.update();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (game.isGameContinues()) {
                game.update();
            }
        });

        thread1.start();
        thread2.start();
    }
}
