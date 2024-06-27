package faang.school.godbless.sprint_3.multithreading_synchronization.task_4_broForce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player serg = new Player(game, "Serg", 10);
        Player kate = new Player(game, "Kate");
        Player mary = new Player(game, "Mary");


        new Thread(game).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(serg).start();
        new Thread(kate).start();
        new Thread(mary).start();

    }
}
