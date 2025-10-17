package bjs290245;

public record Player(String name) {

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println("%s is buttling...");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
