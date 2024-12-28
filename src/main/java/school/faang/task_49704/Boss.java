package school.faang.task_49704;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (maxPlayers > currentPlayers) {
            System.out.println(player.getName() + " добавлен в сражение");
            currentPlayers++;
        } else {
            System.out.println(player.getName() + " ждет очереди");
            wait();
        }
    }

    public synchronized void completionOfTheBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " закончил сражение");
        notify();
    }
}
