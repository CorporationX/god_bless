package school.faang.supercow;

import lombok.SneakyThrows;

public record Player(String name) {
    @SneakyThrows
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        Thread.sleep(3000);
        boss.leaveBattle(this);
    }
}
