package school.faang.sprint3.task49721supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Player {
    private final String name;
    private Boss boss;

    public void startBattle() throws InterruptedException {
        synchronized (boss) {
            boss.joinBattle(this);
            Thread.sleep(500);
            boss.setCurrentPlayers(boss.getCurrentPlayers() - 1);
            System.out.printf("%s completed the battle %n", this.name);
            boss.notifyAll();
        }
    }
}
