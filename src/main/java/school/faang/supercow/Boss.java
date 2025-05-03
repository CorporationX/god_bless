package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.printf("%s ждёт свободного слота...\n", player.getName());
            wait();
        }
        currentPlayers++;
        System.out.printf("%s присоединился к битве! (Сейчас в бою: %d)\n", player.getName(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("%s покинул битву. (Сейчас в бою: %d)\n", player.getName(), currentPlayers);
        notify();
    }
}
