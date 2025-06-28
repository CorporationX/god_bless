package school.faang.bjs2_82178;

public record Player(String name) {
    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание было прерванно");
        }
        boss.leaveBattle(this);
    }
}