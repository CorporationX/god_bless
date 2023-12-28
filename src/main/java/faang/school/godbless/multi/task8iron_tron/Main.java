package faang.school.godbless.multi.task8iron_tron;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        Random random = new Random();

        final int countThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < countThread; i++) {
            int ranInt = random.nextInt(house.getCountRole());
            int finalI = i;
            executorService.submit(() -> {
                User user = new User("User " + finalI);
                try {
                    user.joinHouse(house, house.getRoles().get(ranInt));
                    System.out.println(user.getName() + " играет...");
                    Thread.sleep(4000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    System.out.println("Игра прервана");
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println("Игра окончена!");
    }
}
