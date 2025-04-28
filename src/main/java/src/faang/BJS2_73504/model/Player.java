package src.faang.BJS2_73504.model;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public record Player(String name) {
    private static final int DURATION_BATTLE = 1;

    @SneakyThrows
    public void doBattle(final Boss boss) {
        boss.joinBattle(this);
        TimeUnit.SECONDS.sleep(DURATION_BATTLE);
        boss.leaveBattle(this);
    }
}
