package school.faang.task_49668;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 150; i++) {
            boolean earnedPoints = Math.random() > 0.7;
            boolean lostLife = Math.random() > 0.2;
            game.update(earnedPoints, lostLife);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
