package school.faang.task_49630;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.name() + " is waiting for a slot to fight the boss.");
            wait();
        }
        currentPlayers++;
        System.out.println(player.name() + " has joined the battle with the boss!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.name() + " has finished fighting the boss!");
        notify();
    }
}