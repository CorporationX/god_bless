package faang.school.godbless.ironThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House("Starks");
        List<String> roles = new ArrayList<>();
        roles.add("Lord");
        roles.add("Knight");
        roles.add("Stalker");
        roles.add("Magician");
        roles.add("Queen");
        house.setAvailableRoles(roles.size());
        house.getRoles().addAll(roles);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("user №" + i));
        }

        ExecutorService executorForJoin = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int a = i;
            executorForJoin.submit(() -> users.get(a).joinHouse(house));
        }

        ExecutorService executorForLeaving = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            final int a = i;
            executorForLeaving.submit(() -> users.get(a).leaveHouse());
        }

        executorForJoin.shutdown();
        executorForLeaving.shutdown();

    }
}
