package school.faang.sprint_3.task_49619;

import lombok.NonNull;

public record Player(@NonNull String name) {
    private static final int BATTLE_TIME = 1000;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            System.out.println("Battle interrupted");
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }
}
