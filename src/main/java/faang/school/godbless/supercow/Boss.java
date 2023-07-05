package faang.school.godbless.supercow;

public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            currentPlayers++;
            if (currentPlayers > maxPlayers) {
                System.out.println(player.getName() + " ожидает очереди");
                this.wait();
            }
            System.out.println(player.getName() + " присоединился к битве");
        }
    }

    public void endBattle(Player player) {
        synchronized (this) {
            System.out.println(player.getName() + " закончил битву");
            currentPlayers--;
            notifyAll();
        }
    }
}
