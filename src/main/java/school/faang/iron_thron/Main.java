package school.faang.iron_thron;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");
        User user5 = new User("User5");
        User user6 = new User("User6");

        List<User> users = new ArrayList<>(List.of(user1, user2, user3, user4, user5, user6));

        final int countThreads = 5;

        ExecutorService service = Executors.newFixedThreadPool(countThreads);

        for (int i = 0; i < users.size(); i++) {
            int finalI = i;
            service.submit(() -> {
                try {
                    User user = users.get(finalI);
                    user.joinHouse(house);

                    Thread.sleep(1000);

                    user.leaveHouse(house);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        service.shutdown();

        try{
            if (!service.awaitTermination(1, TimeUnit.MINUTES)){
                service.shutdownNow();
            }
        }catch (InterruptedException e){
            service.shutdownNow();
        }
    }
}
