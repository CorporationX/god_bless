package faang.school.godbless.synchronizationWaitNotify.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.printf("Поток: %s. игрок: %s ожидает сражения.\n", Thread.currentThread().getName(), player.getName());
            this.wait();
        }

        currentPlayers++;
        System.out.printf("Поток: %s. игрок: %s присоединяется к сражению.\n", Thread.currentThread().getName(), player.getName());
    }

    public synchronized void completeBattle(Player player) throws InterruptedException {
        currentPlayers--;
        System.out.printf("Поток: %s. игрок: %s завершает сражение.\n", Thread.currentThread().getName(), player.getName());
        this.notify();
    }
}
