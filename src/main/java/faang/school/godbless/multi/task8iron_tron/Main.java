package faang.school.godbless.multi.task8iron_tron;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House(5);

        final int countThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);

        for (int i = 0; i < countThread; i++) {
            int finalI = i;
            executorService.submit(() -> {
                User user = new User("User " + finalI, house, "Роль " + finalI);
                user.play();
            });
        }

        System.out.println("Игра окончена!");
        executorService.shutdown();
    }
}
