package school.faang.task_49658;

import lombok.Getter;

@Getter
public class Player {
    private static final int BATTLE_DURATION_MS = 3000;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            Boss.LOGGER.error("{} Ошибка сражения!", e.getMessage());
        }
        Thread.sleep(BATTLE_DURATION_MS);
        try {
            boss.leaveBattle(this);
        } catch (Exception e) {
            Boss.LOGGER.error("{} Ошибка в освобождении слотов", e.getMessage());
        }
    }
}
