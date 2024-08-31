package faang.school.godbless.ironThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 15;
    public static void main(String[] args) {
        House house = new House();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            User user = new User(Integer.toString(i));
            users.add(user);
            executorService.submit(() -> user.joinHouse(house));
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        for (User user : users) {
            if (user.getRole()!= null && user.getHouse()!=null) {
                executorService.submit(user::leaveHouse);
            }
        }


        executorService.shutdown();
        try{
            if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
