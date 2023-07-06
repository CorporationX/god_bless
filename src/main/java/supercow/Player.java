package supercow;

import lombok.SneakyThrows;

public record Player(String name) {
    @SneakyThrows(InterruptedException.class)
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " started the boss battle");
        Thread.sleep(2000);
        boss.playerFinishedBattle();
    }
}
