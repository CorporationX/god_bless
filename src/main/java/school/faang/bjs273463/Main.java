package school.faang.bjs273463;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        for (int i = 1; i <= 15; i++) {
            Player player = new Player("Игрок " + i);

            Thread thread = new Thread(() -> {
                player.doBattle(boss);
            }, player.getName());
            thread.start();
        }
    }
}
