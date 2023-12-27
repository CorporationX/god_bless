package faang.school.godbless.multi.task7supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            wait();
        }

        currentPlayers++;
        System.out.println(player.getName() + " присоединился к битве");
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getPlayerName() + " завершил битву");
        notify();
    }

}
