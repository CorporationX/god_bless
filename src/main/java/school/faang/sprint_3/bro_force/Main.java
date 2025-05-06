package school.faang.sprint_3.bro_force;


public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 3);
        Runnable scoreUpdater = () -> {
            while (!game.gameOver()) {
                game.update("score");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " — stopped updating score");
        };

        Runnable livesUpdater = () -> {
            while (!game.gameOver()) {
                game.update("lives");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " — stopped updating lives");
        };

        for (int i = 0; i < 3; i++) {
            new Thread(scoreUpdater, "ScoreThread-" + i).start();
        }

        new Thread(livesUpdater, "LivesThread").start();
    }
}
