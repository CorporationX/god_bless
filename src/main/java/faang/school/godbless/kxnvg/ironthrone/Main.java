package faang.school.godbless.kxnvg.ironthrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        House house = new House("Вестерос");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            users.add(new User("user" + i));
        }

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            final int a = i;
            service.submit(() -> users.get(a).joinHouse(house));
        }

        for (int i = 0; i < 6; i++) {
            final int a = i;
            service.submit(() -> users.get(a).leaveHouse());
        }
        service.shutdown();
    }
}
