package faang.school.godbless.multithreading.iron_throne;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        House house = new House(List.of("Lord", "Mage", "Knight", "Queen", "Warrior"), new AtomicInteger(5));

        IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new User("User-" + i, house))
                .map(Thread::new)
                .forEach(Thread::start);
    }
}
