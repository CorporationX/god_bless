package school.faang.task_49801;

public record Player(String name) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
