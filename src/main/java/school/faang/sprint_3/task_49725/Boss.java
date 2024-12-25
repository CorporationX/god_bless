package school.faang.sprint_3.task_49725;

public class Boss {
    private final int maxPlayers;
    private int currentPlayer;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayer = 0;
    }
    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayer >= maxPlayers) {
            System.out.println(player.getName() + " в процессе ожидания");
            wait();
        }

        currentPlayer++;
        System.out.println(player.getName() + " подключился к файту");
    }

    public synchronized void leaveBattle(Player player) throws InterruptedException {
        currentPlayer--;
        System.out.println(player.getName() + " покинул файт");
        notifyAll();
    }
}
