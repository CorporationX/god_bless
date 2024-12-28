package school.faang.bjs249600;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("The tread was interrupted {}", e.getMessage());
        }
        boss.leaveBattle(this);
    }
}