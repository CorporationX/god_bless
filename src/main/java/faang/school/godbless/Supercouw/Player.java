package faang.school.godbless.Supercouw;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}