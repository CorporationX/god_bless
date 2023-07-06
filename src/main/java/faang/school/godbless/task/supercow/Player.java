package faang.school.godbless.task.supercow;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Player {
    private final String login;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.login + " prepare! Fight!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Boss was humiliated by " + this.login);

        synchronized (boss.getCurrentPlayers()) {
            boss.getCurrentPlayers().remove(this);
            boss.getCurrentPlayers().notifyAll();
        }
    }
}
