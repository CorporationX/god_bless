package school.faang.sprint_3.task_bjs249673;

public record Player(String name) {

    public void startBattle(Boss boss) {
        boss.fightBoss(this);
    }
}
