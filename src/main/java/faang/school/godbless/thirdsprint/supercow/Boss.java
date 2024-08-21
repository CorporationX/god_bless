package faang.school.godbless.thirdsprint.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет освобождения слота...");
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Interrupted exception: {}", e.getMessage());
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению! Текущие игроки: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        notify();
        System.out.println(player.getName() + " завершил сражение. Текущие игроки: " + currentPlayers);
    }
}
