package school.faang.ironThrone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = Arrays.asList(new User("Егор"), new User("Богдан"),
                new User("Денис"), new User("Матвей"), new User("Давид"),
                new User("Степан"), new User("Артур"), new User("Артём"));
        List<String> roles = new ArrayList<>();
        roles.add("Рыцарь");
        roles.add("Маг");
        roles.add("Лучник");
        roles.add("Паладин");
        House house = new House(roles);

        ExecutorService executor = Executors.newFixedThreadPool(users.size());

        users.forEach(user -> executor.submit(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(3000);
                user.leaveHouse(house);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);
    }

}

