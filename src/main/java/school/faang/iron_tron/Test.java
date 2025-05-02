package school.faang.iron_tron;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        House fangSchool = new House();
        int maxUsers = 6;

        IntStream.range(0, maxUsers)
                .mapToObj(object -> new Thread(() -> new User().joinHouse(fangSchool, "Ворон")))
                .forEach(Thread::start);
    }
}
