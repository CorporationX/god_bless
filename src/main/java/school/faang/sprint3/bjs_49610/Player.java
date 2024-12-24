package school.faang.sprint3.bjs_49610;

public record Player(String playerName) {

    public void startGame(Boss boss) throws InterruptedException {
        boss.joinGame(this);
    }

    public void finishGame(Boss boss) {
        boss.gameOver(this);
    }
}
