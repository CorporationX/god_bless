package school.faang.supercow;

public record Player(String name) {
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}