package faang.school.godbless.BJS2_24383;

class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " ждёт, пока появится свободный слот для сражения.");
                lock.wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к сражению. Текущие игроки: " + currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " завершил сражение. Текущие игроки: " + currentPlayers);
            lock.notify();
        }
    }
}
