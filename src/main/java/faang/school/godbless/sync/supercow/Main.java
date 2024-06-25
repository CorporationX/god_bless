package faang.school.godbless.sync.supercow;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var boss = new Boss(3);
        var players = List.of(
                new Player("George"),
                new Player("Ringo"),
                new Player("Paul"),
                new Player("John"),
                new Player("James"),
                new Player("Andrew"),
                new Player("Simon"),
                new Player("Mathew"),
                new Player("Drew"),
                new Player("Michael"),
                new Player("Sarah"),
                new Player("Jessica"),
                new Player("David"),
                new Player("Emma"),
                new Player("Olivia"),
                new Player("Daniel"),
                new Player("Lucas"),
                new Player("Liam"),
                new Player("Ethan"),
                new Player("Sophia")
        );

        players.forEach(player -> new Thread(() -> player.startBattle(boss)).start());
    }
}
