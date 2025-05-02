package school.faang.bjs2_73524;

import java.util.List;

/**
 * Задача "Supercow!"
 */
public class Main {

    public static void main(String[] args) {
        Boss smallBoss = new Boss(3);

        List<Player> players = List.of(
                new Player("Первый", 5),
                new Player("Второй", 2),
                new Player("Третий", 7),
                new Player("Четвертый", 12),
                new Player("Пятый", 3),
                new Player("Шестой", 6),
                new Player("Седьмой", 4)
        );

        players.forEach(
                player -> new Thread(() -> player.doBattle(smallBoss)).start()
        );
    }
}
