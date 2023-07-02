package faang.school.godbless.multithreading.iron_throne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IronThrone {
    public static void main(String[] args) throws InterruptedException {
        House house = new House("Westors");
        User user1 = new User("Tom");
        User user2 = new User("Bob");
        User user3 = new User("Peter");
        User user4 = new User("Alice");
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(()-> user1.joinHouse(house, "Lord"));
        service.execute(()-> user2.joinHouse(house, "Knight"));
        service.execute(()-> user3.joinHouse(house, "Mage"));
        service.execute(()-> user4.joinHouse(house, "Lord"));
        service.shutdown();
        Thread.sleep(2000);
        user1.leaveHouse();
    }
}
