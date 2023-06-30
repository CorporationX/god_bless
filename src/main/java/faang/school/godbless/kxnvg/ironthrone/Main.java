package faang.school.godbless.kxnvg.ironthrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        House house = new House("Вестерос");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            users.add(new User("user" + i));
        }

        ExecutorService joinService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int a = i;
            joinService.submit(() -> users.get(a).joinHouse(house));
        }

        ExecutorService leavingService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            final int a = i;
            leavingService.submit(() -> users.get(a).leaveHouse());
        }

        joinService.shutdown();
        leavingService.shutdown();
    }
}
