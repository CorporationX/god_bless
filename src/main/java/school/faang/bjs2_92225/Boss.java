package school.faang.bjs2_92225;


import lombok.SneakyThrows;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (lock) {
            System.out.printf("%s пытается присоединиться к бою. Текущих игроков: %d%n",
                    player.getName(), currentPlayers);

            while (currentPlayers >= maxPlayers) {
                System.out.printf("%s ждет свободное место...%n", player.getName());
                lock.wait();
            }

            currentPlayers++;
            System.out.printf("%s присоединился к бою! Игроков в бою: %d%n",
                    player.getName(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("%s покинул бой. Осталось игроков: %d%n",
                    player.getName(), currentPlayers);
            lock.notify();
        }
    }
}
