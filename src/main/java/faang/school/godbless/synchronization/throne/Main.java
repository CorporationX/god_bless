package faang.school.godbless.synchronization.throne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int THREAD_COUNT = 10;
    public static void main(String[] args) {

        Map<Role, Integer> roles = new HashMap<>();
        roles.put(Role.LORD, 1);
        roles.put(Role.MAGE, 3);
        roles.put(Role.WARRIOR, 10);

        House house = new House("Barateon", roles);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        List<User> userList = new ArrayList<>();

        userList.add(new User("User1", Role.MAGE));
        userList.add(new User("User2", Role.WARRIOR));
        userList.add(new User("User3", Role.LORD));
        userList.add(new User("User4", Role.MAGE));
        userList.add(new User("User5", Role.MAGE));
        userList.add(new User("User6", Role.LORD));
        userList.add(new User("User7", Role.WARRIOR));
        userList.add(new User("User8", Role.WARRIOR));
        userList.add(new User("User9", Role.LORD));
        userList.add(new User("User10", Role.MAGE));

        userList.forEach(user -> executorService.execute(() -> {user.joinHouse(house);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse(house);}));

        executorService.shutdown();
    }
}
