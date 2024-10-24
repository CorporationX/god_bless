package school.faang_sprint_3.iron_throne_in_any_cost;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        var house = new House("Westeros", Arrays.asList(Role.values()));
        var jon = new User("Jon Snow");
        var daenerys = new User("Daenerys Targaryen");
        var tyrion = new User("Tyrion Lannister");
        var hodor = new User("Hodor");
        var arya = new User("Arya Stark");

        var threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(() -> jon.joinHouse(house));
        threadPool.submit(() -> daenerys.joinHouse(house));
        threadPool.submit(() -> tyrion.joinHouse(house));
        threadPool.submit(() -> hodor.joinHouse(house));
        threadPool.submit(() -> arya.joinHouse(house));
        threadPool.submit(() -> jon.leaveHouse(house));
        threadPool.shutdown();
    }
}
