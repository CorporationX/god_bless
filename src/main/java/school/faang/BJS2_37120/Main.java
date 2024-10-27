package school.faang.BJS2_37120;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<String> roles = Arrays.asList("Lord", "Knights", "Wizard");
        House house = new House(roles);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            User user = new User("Unit" + i, house);
            executor.submit(user);
        }

        executor.shutdown();
    }
}
