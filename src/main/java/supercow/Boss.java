package supercow;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();
    private boolean needToStartTheJoinThreadFasterThanBattleThread = false;

    public Boss(int maxPlayers, int currentPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.println("Все слоты заняты. " + player.getName() + " не может войти.");
                lock.wait();
            }
            System.out.println(player.getName() + " зашел в игру");
            currentPlayers++;
            needToStartTheJoinThreadFasterThanBattleThread = true;
            lock.notifyAll();
        }
    }

    public void startBattle() throws InterruptedException {
        if (needToStartTheJoinThreadFasterThanBattleThread) {
            synchronized (lock) {
                if (currentPlayers == 0) {
                    System.out.println("Нет игроков для битвы. Ожидание игроков...");
                    return;
                }
                System.out.println("Бой начался");
                Thread.sleep(5000);
                System.out.println("Бой закончился. Слоты освободились");
                currentPlayers = 0;
                lock.notifyAll();
            }
        }
    }
}