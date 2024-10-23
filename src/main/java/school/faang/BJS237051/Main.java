package school.faang.BJS237051;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<String> roles = List.of("Рыцарь", "Ассасин", "Варг", "Оруженосец");

        House starkHouse = new House(roles);

        users.add(new User("Джон"));
        users.add(new User("Ария"));
        users.add(new User("Бран"));
        users.add(new User("Ходор"));
        users.add(new User("Эддард"));
        users.add(new User("Кейтилин"));
        users.add(new User("Робб"));
        users.add(new User("Рикон"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (User user : users) {
            executor.submit(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(5000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                System.out.println("Кто-то очень долго думает!");
            } else {
                System.out.println("Все сделали свой выбор!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
