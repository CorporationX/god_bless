package school.faang.task323;

import school.faang.task323.character.Boss;
import school.faang.task323.character.Player;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player firstPlayer = new Player("Gamer1");
        Player secondPlayer = new Player("Gamer2");
        Player thirdPlayer = new Player("Gamer3");
        Player fourthPlayer = new Player("Gamer4");

        Stream.of(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer)
                .forEach(P -> new Thread(() -> P.startBattle(boss)).start());
    }
}
