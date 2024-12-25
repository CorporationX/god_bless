package school.faang.sprint_3.task_49725;
import lombok.Getter;

public class Player implements Runnable {
    @Getter
    private String name;
    private final Boss boss;

    public Player(int name, Boss boss) {
        this.name = String.valueOf(name);
        this.boss = boss;
    }

    @Override
    public void run(){
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep((long)(Math.random() * 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " закончил файт");
        try {
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
