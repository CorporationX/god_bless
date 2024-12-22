package school.faang.bjs249310;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        // Имитируем игровой цикл
        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Произошла ошибка во время задержки");
            }
        }
    }
}
