package school.faang.task_49630;

public record Player(String name) {
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);

        System.out.println(name + " fights the boss...");
        Thread.sleep(2000);

        boss.leaveBattle(this);
    }
}