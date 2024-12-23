package school.faang.task_49567;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 50; i++) {
            boolean scoresPoints = Math.random() > 0.5;
            boolean losesLife = Math.random() > 0.7;

            System.out.println("scoresPoints " + scoresPoints + "; losesLife " + losesLife);

            game.update(scoresPoints, losesLife);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("!!!Exception!!! " + e);
            }
        }
    }
}
