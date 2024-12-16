package school.faang.task49620;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
