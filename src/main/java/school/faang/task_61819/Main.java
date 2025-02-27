package school.faang.task_61819;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(4);

        @SuppressWarnings("BusyWait")
        Runnable gameUpdateTask = () -> {
            while (game.getLives() > 0) {
                boolean isPointsEarned = Math.random() > 0.5;
                boolean isLifeLost = Math.random() > 0.7;

                game.update(isPointsEarned, isLifeLost);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток был прерван! " + e);
                    return;
                }
            }
        };

        final Thread gameThread1 = new Thread(gameUpdateTask);
        final Thread gameThread2 = new Thread(gameUpdateTask);
        final Thread gameThread3 = new Thread(gameUpdateTask);
        final Thread gameThread4 = new Thread(gameUpdateTask);

        gameThread1.start();
        gameThread2.start();
        gameThread3.start();
        gameThread4.start();

        try {
            gameThread1.join();
            gameThread2.join();
            gameThread3.join();
            gameThread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток был прерван! " + e);
            return;
        }

        System.out.println("Игра завершена!");
    }
}
