package faang.school.godbless.BJS2_24371;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Lock lock = new Lock();

    Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            currentPlayers++;
            System.out.println(player.getName() + " has joined the battle. Current players: " + currentPlayers);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            endBattle(player);
        }
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " has finished the battle. Current players: " + currentPlayers);
            lock.notify();
        }
    }
}
