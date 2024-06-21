package faang.school.godbless.theIronThroneatAnyCost;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_NUM = 2;

    public static void main(String[] args) {
        Role role1 = new Role("Mag");
        Role role2 = new Role("Knight");
        Role role3 = new Role("Swordsman");
        Role role4 = new Role("Lord");

        List<Role> allRoles = new ArrayList<>();
        allRoles.add(role1);
        allRoles.add(role2);

        House house = new House(allRoles, allRoles);

        List<User> users = List.of(new User("User1", role1, house),
                new User("User2", role2, house),
                new User("User3", role3, house),
                new User("User4", role4, house));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

        for (User user : users) {
            executor.submit(() -> {
                user.joinHouse(house);
            });
        }

        for (User user : house.getUserRoles().keySet()) {
            executor.submit(() -> {
                user.leaveHouse(house);
            });
        }

        executor.shutdown();
    }
}
