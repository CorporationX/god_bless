package school.faang.supercow;


public record Player(String name) {
    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(1000);
        boss.leaveBattle(this);
    }
}
