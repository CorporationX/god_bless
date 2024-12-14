package school.faang.java.thread1.supercow;

public class Boss {
    private final int maxNumberPlayers = 3;
    private int currenNumberPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currenNumberPlayers >= maxNumberPlayers) {
            System.out.println("Waiting user - " + player.getName());
            this.wait();
        }
        System.out.println("Added player: " + player.toString());
        currenNumberPlayers++;
    }

    public synchronized void leaveBattle(Player player) throws InterruptedException {
        System.out.println("Leaving user - " + player.getName());
        currenNumberPlayers--;
        this.notify();
    }
}
