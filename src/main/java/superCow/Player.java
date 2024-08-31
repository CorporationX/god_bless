package superCow;

import lombok.Getter;

@Getter
public class Player {
    private String name;
    private Object lock = new Object();

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        synchronized (lock) {
            boss.joinBattle(this);
            if (boss.getCurrentPlayers() >= boss.getMAX_PLAYERS()) {
                System.out.println("игрок " + Player.this.getName() + " ожидает");
                lock.wait();
            }
            if (boss.getCurrentPlayers() >= boss.getMAX_PLAYERS()) {
                System.out.println("игрок " + Player.this.getName() + " завершил бой");
                boss.setCurrentPlayers(boss.getCurrentPlayers() - 1);
            }
        }
    }
}
