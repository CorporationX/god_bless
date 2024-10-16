package school.BJS2_36845;

public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers == maxPlayers) {
            System.out.println("Босс занят, иди помоги маме " + player.getName());
            wait();
        }
        System.out.println("К битве добавлен новый игрок: " + player.getName());
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Из игры удален игрок: " + player.getName());
        notify();
    }
}
