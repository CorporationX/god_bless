package faang.school.godbless.Multitrading2.IronThron;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<String> roles = List.of("Lord", "King", "Queen");
        House house = new House("Targarians", roles, roles.size());

        User user1 = new User("Daenerys Targaryen");
        User user2 = new User("Tyrion Lannister");
        User user3 = new User("John Snow");
        User user4 = new User("Caytelin Stark");
        User user5 = new User("Someone Stark");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> user1.joinHouse(house,roles.get(0)));
        service.execute(() -> user2.joinHouse(house,roles.get(1)));
        service.execute(() -> user3.joinHouse(house,roles.get(2)));
        service.execute(() -> user3.leaveHouse(house));
        service.execute(() -> user4.joinHouse(house,roles.get(2)));
        service.execute(() -> user5.joinHouse(house,roles.get(2)));
        service.execute(() -> user4.leaveHouse(house));
        service.shutdown();
    }
}
