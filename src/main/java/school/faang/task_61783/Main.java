package school.faang.task_61783;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 50; i++) {
            boolean isScoresIncrease = Math.random() > 0.5;
            boolean isLivesDecrease = Math.random() > 0.7;

            game.update(isScoresIncrease, isLivesDecrease);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ожидание основного потока прервано");
                throw new RuntimeException(e);
            }
        }
    }
}
