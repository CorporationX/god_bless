package faang.school.godbless.multithreading.iron_throne;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IronThrone {
    public static void main(String[] args) throws InterruptedException {
        House house = new House("Westors");
        List<User> users = setUp(house);
        ExecutorService service = Executors.newCachedThreadPool();

        for (User user : users) {
            service.execute(user);
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static List<User> setUp(House house) {
        return List.of(
                new User("Tom", house, "Lord"),
                new User("Bob", house, "Knight"),
                new User("Peter", house, "Mage"),
                new User("Alice", house, "Lord"));
    }
}
