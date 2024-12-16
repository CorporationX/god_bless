package school.faang.task49620;

public record Player(String name) {
    public void startBattle(Boss boss) {
        if (boss == null){
            throw new IllegalArgumentException("boss can`t be null");
        }
        boss.joinBattle(this);
    }
}
