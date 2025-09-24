package school.faang.bjs2_90530;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> roles = Arrays.asList("Хозяин", "Гость", "Повар", "Гардеробщик");
        House house = new House(roles);

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            User user = new User("Игрок-" + i, null, house);
            Thread thread = new Thread(user);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Все пользователи завершили работу");
    }
}