package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Person person1 = new Person("Tom", 10);
        Person person2 = new Person("Jerry", 4);
        game.addPerson(person1);
        game.addPerson(person2);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        while (!game.isGameOver()) {
            executorService.execute(game::update);
            Thread.sleep(2000);
        }

        executorService.shutdown();
        System.out.println("Game over!");
    }
}