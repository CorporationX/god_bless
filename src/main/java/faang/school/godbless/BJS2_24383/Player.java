package faang.school.godbless.BJS2_24383;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
class Player implements Runnable {
    @Getter
    private final String name;
    private final Boss boss;

    public void startBattle() throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(2000);
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        try {
            startBattle();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
