package school.faang.sprint_3.task_49712;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ждёт очереди");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
                Thread.currentThread().interrupt();
                return;
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул чат");
        notify();
    }
}
