package school.faang.Mnogopotochka.Synhronaized.BJS2_36782;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss dragon = new Boss(3);

        List<Player> players = new ArrayList<>(List.of(
                new Player("Dima", dragon),
                new Player("Alex", dragon),
                new Player("Maria", dragon),
                new Player("John", dragon),
                new Player("Sophia", dragon),
                new Player("Michael", dragon),
                new Player("Emma", dragon),
                new Player("Daniel", dragon),
                new Player("Olivia", dragon),
                new Player("James", dragon),
                new Player("Isabella", dragon)
        ));

        players.forEach(Thread::start);
    }
}
