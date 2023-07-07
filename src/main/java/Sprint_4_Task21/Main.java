package Sprint_4_Task21;

import lombok.SneakyThrows;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        House house = new House();
        User user1 = new User("user1", house, Role.Lord);
        User user2 = new User("user2", house, Role.Lord);
        User user3 = new User("user3", house, Role.Lord);
        User user4 = new User("user4", house, Role.Lord);
        User user5 = new User("user5", house, Role.Lord);


        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(user1::joinHouse);
        executor.submit(user1::leaveHouse);
        executor.execute(user2::joinHouse);
        executor.execute(user3::joinHouse);
        executor.execute(user4::joinHouse);
        executor.execute(user2::leaveHouse);
        executor.execute(user5::joinHouse);
        executor.execute(user3::leaveHouse);
        executor.execute(user4::leaveHouse);


        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Конец");
    }
}
