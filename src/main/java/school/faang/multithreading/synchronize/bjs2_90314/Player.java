package school.faang.multithreading.synchronize.bjs2_90314;

public record Player(
        String name
) {
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }
}