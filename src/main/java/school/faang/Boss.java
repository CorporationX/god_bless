package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public static void main(String[] args) {
        Boss cow = new Boss();

        Player ron = new Player("Ron");
        Thread ronBattle = new Thread(() -> ron.doBattle(cow));
        ronBattle.start();

        Player ben = new Player("Ben");
        Thread benBattle = new Thread(() -> ben.doBattle(cow));
        benBattle.start();

        Player dan = new Player("Dan");
        Thread danBattle = new Thread(() -> dan.doBattle(cow));
        danBattle.start();

        Player bob = new Player("Bob");
        Thread bobBattle = new Thread(() -> bob.doBattle(cow));
        bobBattle.start();


    }

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("Поток был прерван");
        } finally {
            boss.leaveBattle(this);
        }
    }

}
