package faang.school.godbless.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        boss.leaveBattle(this);
    }
}