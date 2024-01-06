package faang.school.godbless.IronThrone;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> roles = new HashMap<>() {{
            put("Lord", 1);
            put("knight", 2);
            put("magician", 2);
        }};

        List<User> users = new ArrayList<>();
        House stark = new House("House Stark", roles);
        House martell = new House("House Martell", roles);
        House lannister = new House("House Lannister", roles);

        for (int i = 0; i < 10; i++) {
            users.add(new User("User" + i));
        }
       // System.out.println(users.toString());

        ExecutorService executor = Executors.newFixedThreadPool(5);
        users.forEach(user -> executor.submit(() -> {
            user.joinHouse(stark);
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        }));
        executor.shutdown();
    }
}
