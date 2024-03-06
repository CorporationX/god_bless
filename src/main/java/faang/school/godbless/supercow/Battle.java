package faang.school.godbless.supercow;

import lombok.RequiredArgsConstructor;

import java.util.Random;

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
            if (!(BOSS.getCurrentPlayers().size() == BOSS.getMaxPlayers())) {
                BOSS.setCurrentPlayers(PLAYER);
            } else {
                System.out.println("Player: " + PLAYER.getName() + " в ожидании подключения");
                BOSS.wait();
            }
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