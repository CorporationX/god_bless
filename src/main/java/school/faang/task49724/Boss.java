package school.faang.task49724;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println("Ожидание свободных мест");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к битве");
    }

    public synchronized void getOutBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " Вышел из боя!");
        notify();
    }
}
