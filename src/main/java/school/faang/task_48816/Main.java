package school.faang.task_48816;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    public static void main(String[] args) {
        List<String> starkHouseRoles = Arrays.asList("Lord", "Knight", "Mage");
        House starkHouse = new House("Stark", starkHouseRoles);
        User user1 = new User("John");
        User user2 = new User("Arya");
        User user3 = new User("Sansa");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);


    }
}
