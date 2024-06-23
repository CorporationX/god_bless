package faang.school.godbless.sync.supercow;

public record Player(String name) {

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
