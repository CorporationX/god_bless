package faang.school.godbless.multithreading.ironthrone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        House targarien = new House(List.of(Role.values()), 0);

        var users = List.of(new User("Daenerys", targarien, Role.MAGE),
                new User("Vezeris", targarien, Role.KNIGHT),
                new User("Reygar", targarien, null),
                new User("Strong", targarien, null));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        users.forEach(user -> executorService.execute(() -> {
            try {
                if (user.getRole() == null) {
                    user.joinHouse();
                } else {
                    user.leaveHouse();
                }
            } catch (InterruptedException e) {
                System.out.println("> something has gone wrong");
            }
        }));

        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            executorService.shutdown();
        } else {
            executorService.shutdownNow();
        }

        users.forEach(System.out::println);
        System.out.println(targarien);
    }

}
