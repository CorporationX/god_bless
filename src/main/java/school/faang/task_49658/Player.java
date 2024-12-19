package school.faang.task_49658;

import lombok.Getter;

@Getter
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        try {
            boss.joinBattle(this);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage() + " Ошибка сражения!");
        }
        Thread.sleep(3000);
        try {
            boss.leaveBattle(this);
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " Ошибка в освобождении слотов");
        }
    }
}
