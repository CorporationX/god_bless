package faang.school.godbless.multithreading.supercow;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
