package school.faang_sprint_3.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        fighting();
    }

    public void fighting() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("An exception occurred while fighting", e);
            throw new ThreadInterruptException("Thread is interrupted" + e.getMessage());
        }
    }
}