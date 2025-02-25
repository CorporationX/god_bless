package school.faang.supercow;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    private static final int BATTLE_TIME = 3000;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("{} начинает бой!", this.name());
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            log.error("Поток игрка {} прерван {}", this.name(), e.getMessage(), e);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
