package school.faang.sprint_3.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(0); // начальное количество игроков — 0, maxPlayers = 6 внутри класса
        for (int i = 1; i <= 10; i++) {
            final int playerId = i;
            Thread thread = new Thread(() -> {
                Player player = new Player("Player-" + playerId);
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            thread.start();
        }
    }
}
