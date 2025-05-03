package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.printf(player.getName() + "%d ждёт свободного слота...");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к битве! (Сейчас в бою: " + currentPlayers + ")");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул битву. (Сейчас в бою: " + currentPlayers + ")");
        notify();
    }
}
