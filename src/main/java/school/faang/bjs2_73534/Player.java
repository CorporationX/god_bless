package school.faang.bjs2_73534;

public record Player(String name) {
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
