package school.faang.bjs2_82171;

public record Player(String name) {

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);

            System.out.println(name + " is fighting the boss...");
            Thread.sleep(2000);

            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }
    }
}
