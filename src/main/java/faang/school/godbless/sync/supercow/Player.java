package faang.school.godbless.sync.supercow;

public record Player(String name) {

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(1000);
            boss.exitBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
