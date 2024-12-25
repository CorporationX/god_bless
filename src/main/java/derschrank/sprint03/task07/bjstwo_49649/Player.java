package derschrank.sprint03.task07.bjstwo_49649;

public record Player(
        String name
) {
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Player " + this + " was interrupt. " + e);
        }
        boss.leaveBattle(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
