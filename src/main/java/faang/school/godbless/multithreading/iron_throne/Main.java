package faang.school.godbless.multithreading.iron_throne;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        House house = new House(List.of("Lord", "Mage", "Knight", "Queen", "Warrior"), 5);

        List<Thread> threads = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new User("User-" + i, house))
                .map(user -> new Thread(user::joinHouse))
                .toList();

        threads.forEach(Thread::start);
    }
}
