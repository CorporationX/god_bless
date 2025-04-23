package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("Игрок {} с босом {}", this.name(), boss.getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Поток {} прерван", Thread.currentThread(), e);
        }
        boss.leaveBattle(this);
    }
}
