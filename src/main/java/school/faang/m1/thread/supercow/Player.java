package school.faang.m1.thread.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    void doBattle(Boss boss) {
        try {
            System.out.println(this + " attempt join battle with boss");
            boss.joinBattle(this);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
            System.out.println(this + " left the battle!");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
