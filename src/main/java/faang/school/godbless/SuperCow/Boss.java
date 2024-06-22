package faang.school.godbless.SuperCow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    private final Object lock = new Object();


    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers > maxPlayers) {
                try {
                    System.out.println("Нет слотов для игрока " + player.getName() + ". Ожидание");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток игрока " + player.getName() + "Был к сожалению прерван");
                    return;
                }
            }
            currentPlayers++;
            System.out.println("123грок " + player.getName() + "Вступил в сражение");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= 0) {
                currentPlayers--;
                System.out.println("Player " + player.getName() + " left the battle");
                lock.notify();
            }
        }
    }
}
