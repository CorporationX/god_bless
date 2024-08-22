package faang.school.godbless.supercow;

public record Player(String name) {

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }
}
