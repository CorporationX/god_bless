package faang.school.godbless.supercow;

public record Player(String name) {
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(4000);
        System.out.println("Player " + this.name + " is start fighting with boss: " + boss);
        boss.endPlaying(this);
    }
}
