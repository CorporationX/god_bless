package school.faang.force;

public class ForceMain {
    public static void main(String[] args) {
        Game game = new Game(0, 3);

        // Симуляция игрового цикла
        for (int i = 0; i < 10; i++) {
            boolean scored = Math.random() > 0.7;
            boolean lostLife = Math.random() > 0.5;
            game.update(scored, lostLife);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
