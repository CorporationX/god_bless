package school.faang.task_49567;

public class Main {
    private static final int COUNT_SET = 50;
    private static final double COEF_POINT = 0.5;
    private static final double COEF_LIFE = 0.7;

    public static void main(String[] args) {


        Game game = new Game();

        for (int i = 0; i < COUNT_SET; i++) {
            boolean scoresPoints = Math.random() > COEF_POINT;
            boolean losesLife = Math.random() > COEF_LIFE;

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
