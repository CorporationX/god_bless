package faang.school.godbless.synch3;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        boss.leaveBattle(this);
    }
}
