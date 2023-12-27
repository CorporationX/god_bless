package faang.school.godbless.multi.task7supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player extends Thread{
    private String playerName;
    private Boss boss;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);

            Thread.sleep((int) (Math.random() * 5000));
            boss.endBattle(this);
        } catch (InterruptedException e) {
            System.out.println("Игра прервана");
        }
    }

    @Override
    public void run(){
        startBattle(boss);
    }

}
