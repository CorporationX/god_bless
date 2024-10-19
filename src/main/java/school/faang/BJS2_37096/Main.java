package school.faang.BJS2_37096;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House(Arrays.asList("Лорд", "Маг", "Дворф", "Рыцарь тьмы"));
        User firstUser = new User("Clark", house);
        User secondUser = new User("Bob", house);
        User thirdUser = new User("Ed", house);
        User fourthUser = new User("Franck", house);
        User fifthUser = new User("Drag", house);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(firstUser);
        executor.submit(secondUser);
        executor.submit(thirdUser);
        executor.submit(fourthUser);
        executor.submit(fifthUser);

        executor.shutdown();
    }
}
