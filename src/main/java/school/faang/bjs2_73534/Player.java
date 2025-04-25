package school.faang.bjs2_73534;

public record Player(String name) {
    private static final Integer BATTLE_TIME = 3000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
