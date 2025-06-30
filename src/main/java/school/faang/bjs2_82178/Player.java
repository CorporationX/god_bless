package school.faang.bjs2_82178;

public record Player(String name) {
    private static final int TIME_SLEEP_MS = 3000;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(TIME_SLEEP_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание было прерванно");
        }
        boss.leaveBattle(this);
    }
}