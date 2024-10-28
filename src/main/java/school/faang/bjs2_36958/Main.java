package school.faang.bjs2_36958;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(6);

        Stream.of(
                        new Player("Archer"),
                        new Player("Warrior"),
                        new Player("Mage"),
                        new Player("Rogue"),
                        new Player("Paladin"),
                        new Player("Hunter"),
                        new Player("Druid"),
                        new Player("Sorcerer"),
                        new Player("Knight"),
                        new Player("Assassin")
                ).map(player -> new Thread(() -> player.startBattle(boss)))
                .forEach(Thread::start);


    }
}
