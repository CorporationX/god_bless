package iron_throne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House("Starks");
        house.addRole("Lord");
        house.addRole("Knight");
        house.addRole("Stalker");
        house.addRole("Magician");
        house.addRole("Queen");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("user #" + (i + 1)));
        }

        ExecutorService executorForJoin = Executors.newFixedThreadPool(10);
        for (User user : users) {
            executorForJoin.submit(() -> user.joinHouse(house));
        }

        ExecutorService executorForLeaving = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            executorForLeaving.submit(() -> users.get(index).leaveHouse());
        }

        executorForJoin.shutdown();
        executorForLeaving.shutdown();
    }
}