package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public synchronized void joinBattle(Boss boss) {
        if (boss.getCurrentPlayers().size() >= boss.getMaxPlayers()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        boss.getCurrentPlayers().add(this);
        System.out.println("Player " + getName() + " joined the battle!");
    }


    public synchronized void leaveBattle(Boss boss) {
        if (boss.getCurrentPlayers().contains(this)) {
            boss.getCurrentPlayers().remove(this);
            System.out.println("Player " + getName() + " left the battle!");

            this.notify();
        } else {
            throw new IllegalArgumentException("Player " + getName() + " not in the battle!");
        }
    }
}
