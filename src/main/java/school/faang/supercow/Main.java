package school.faang.supercow;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Boss boss = new Boss(2);

        List<Player> players = List.of(new Player("Толик"),
                new Player("Колян"),
                new Player("Тимур"),
                new Player("Санек"));

        players.forEach(player -> new Thread(() -> player.doBattle(boss)).start());
    }
}
