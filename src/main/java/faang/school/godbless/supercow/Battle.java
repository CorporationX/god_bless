package faang.school.godbless.supercow;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.Scanner;

@RequiredArgsConstructor
public class Battle implements Runnable {
    private final Boss BOSS;
    private final Player PLAYER;
    private final Random random = new Random();

    public void startBattle(Boss BOSS) throws InterruptedException {
        joinBattle(PLAYER);
        System.out.println("Player: " + PLAYER.getName() + " начал сражение с боссом " + BOSS.getName());
        Thread.sleep(random.nextInt(10000));
        unJoinBattle(PLAYER);
        System.out.println("Player: " + PLAYER.getName() + " завершил сражение с боссом " + BOSS.getName());
    }

    public void unJoinBattle(Player PLAYER) {
        synchronized (BOSS) {
            BOSS.unJoinPlayer(PLAYER);
            BOSS.notify();
        }
    }

    public void joinBattle(Player PLAYER) throws InterruptedException {
        synchronized (BOSS) {
            do {
                if (!(BOSS.getCurrentPlayers().size() == BOSS.getMaxPlayers())) {
                    BOSS.setCurrentPlayers(PLAYER);
                } else {
                    System.out.println("Player: " + PLAYER.getName() + " в ожидании подключения");
                    BOSS.wait();
                }
                System.out.println(PLAYER.getName() + " Есть возможность подключения. Подключаемся к битве?");
            } while (!new Scanner(System.in).nextBoolean());
        }
    }

    @Override
    public void run() {
        try {
            startBattle(BOSS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}