package faang.school.godbless.house;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameOfThrones {
    public static void main(String[] args) {
        House starkHouse = new House("Старки", Arrays.asList("Лорд", "Рыцарь", "Маг"));

        starkHouse.addRole("Лорд", 1);
        starkHouse.addRole("Рыцарь", 1);
        starkHouse.addRole("Маг", 1);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        User user1 = new User("Шелдон", starkHouse);
        User user2 = new User("Леонард", starkHouse);
        User user3 = new User("Говард", starkHouse);
        User user4 = new User("Раджеш", starkHouse);

        // Запускаем пользователей (потоки)
        executor.submit(user1);
        executor.submit(user2);
        executor.submit(user3);
        executor.submit(user4);

        executor.shutdown();
    }
}


