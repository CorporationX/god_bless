package school.faang.task_61683;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5; // 50% шанс заработать очки
            boolean lostLife = Math.random() > 0.7;     // 30% шанс потерять жизнь

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100); // Задержка для симуляции шага игры
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
