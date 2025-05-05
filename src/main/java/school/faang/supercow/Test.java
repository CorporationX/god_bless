package school.faang.supercow;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        int allPlayers = 10;
        IntStream.range(0, allPlayers)
                .mapToObj(object -> new Thread(() -> new Player().doBattle(boss)))
                .forEach(Thread::start);

    }
}
