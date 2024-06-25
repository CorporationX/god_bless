package faang.school.godbless.SuperCow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss){
        try{
            boss.joinBattle(this);
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
