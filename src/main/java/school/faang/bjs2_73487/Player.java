package school.faang.bjs2_73487;

import lombok.Data;

@Data
public class Player {
    private static final int SLEEP_TIME = 1000;

    public void doBattle(Boss boss) {
        try {
            System.out.println("Trying to join battle");
            boss.joinBattle();
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        boss.leaveBattle();
        System.out.println("Player left battle");
    }
}
