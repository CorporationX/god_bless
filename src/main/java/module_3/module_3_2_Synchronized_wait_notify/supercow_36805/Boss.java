package module_3.module_3_2_Synchronized_wait_notify.supercow_36805;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            System.out.println(player.getName() + " ждет свободного слота.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к бою.");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул поле сражения.");
        notify();
    }


}
