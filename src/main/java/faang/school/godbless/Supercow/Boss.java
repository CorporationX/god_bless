package faang.school.godbless.Supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (maxPlayers <= currentPlayers) {
            System.out.println(player + " is waiting");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player + " join the game " + currentPlayers + "/" + maxPlayers);
        //battle(player);
    }

    /*
    public synchronized void battle(Player player) {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        endBattle(player);
    }*/

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println(player + " stop his fight " + currentPlayers + "/" + maxPlayers);
        this.notify();
    }

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}