package faang.school.godbless.multithreading_synchronization.supercow;

public class Boss {
    private int maxPlayers = 2;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            try {
                System.out.println("Сервер заполнен, подождите пока освободится место");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(player.getName() + " зашел в игру");
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " покидает игру");
        currentPlayers--;
        notify();
    }
}
