package faang.school.godbless.thirdSprint.Supercow;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void finishBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
