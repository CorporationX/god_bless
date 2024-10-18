package school.faang;

import lombok.Getter;
import school.faang.Fighter.Fighter;

@Getter
public class ThreadFighter {
    private Fighter fighter;
    private int result;

    public ThreadFighter(Fighter fighter){
        this.fighter = fighter;
    }

    public void run() {
        result = fighter.getPower();
    }
}
