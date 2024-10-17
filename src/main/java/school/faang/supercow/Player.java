package school.faang.supercow;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
