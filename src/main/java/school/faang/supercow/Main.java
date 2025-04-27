package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        boss.status();
        Player[] players = {
                new Player("Alice"),
                new Player("Bob"),
                new Player("Charlie"),
                new Player("Diana"),
                new Player("Eve")
        };

        for (Player player : players) {
            new Thread(() -> player.doBattle(boss), "Thread-" + player.name()).start();
            boss.status();
        }
    }
}
