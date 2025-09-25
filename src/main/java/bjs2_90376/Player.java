package bjs2_90376;

public record Player(String name) {

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " сражается с боссом...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время боя.");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}