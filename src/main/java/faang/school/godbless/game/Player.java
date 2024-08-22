package faang.school.godbless.game;

public record Player(String name) {

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
