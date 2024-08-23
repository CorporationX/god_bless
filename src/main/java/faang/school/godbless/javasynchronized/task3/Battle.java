package faang.school.godbless.javasynchronized.task3;

import java.util.List;

public class Battle {
    public static void main(String[] args) {
        Boss boss = new Boss(5);
        List<Player> players = List.of(new Player("1Masmaatda Silva"),
                new Player("2LaxmiBibi"),
                new Player("3YolandaBegam"),
                new Player("4SoniaWen"),
                new Player("5ZainabVargas"),
                new Player("6RamonCaudhari"),
                new Player("7JingjingKhatun"),
                new Player("8MingMarques")
        );

        players.stream()
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .toList()
                .forEach(Thread::start);
    }
}
