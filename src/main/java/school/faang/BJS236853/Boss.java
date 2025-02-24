package school.faang.BJS236853;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет свободный слот чтобы присоединиться к сражению с боссом");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentPlayers ++;
        System.out.println(player.getName() + " Присоединился к сражению!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers --;
        System.out.println(player.getName() + " завершил сражение с боссом");
        notify();
    }
}
