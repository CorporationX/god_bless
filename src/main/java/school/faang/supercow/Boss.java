package school.faang.supercow;

import lombok.Getter;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Boss
 * Автор: Vital
 */

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("Максимальное количество игроков должно быть > 0");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(player.getName() + " был прерван во время ожидания.");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к сражению с боссом! Текущие игроки: " + currentPlayers);
        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " завершил сражение с боссом! Текущие игроки: " + currentPlayers);
            lock.notify();
        }
    }
}