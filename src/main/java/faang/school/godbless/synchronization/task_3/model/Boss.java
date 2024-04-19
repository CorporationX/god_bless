package faang.school.godbless.synchronization.task_3.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            System.out.println(player.getName() + " присоединяется к сражению");
            currentPlayers++;
        } else {
            try {
                this.wait();
                System.out.println(player.getName() + " ожидает очереди для сражения");
                joinBattle(player);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " выходит из сражения");
        currentPlayers--;
        this.notifyAll();
    }
}