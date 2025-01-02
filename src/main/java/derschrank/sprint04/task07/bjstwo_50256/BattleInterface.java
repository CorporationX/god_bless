package derschrank.sprint04.task07.bjstwo_50256;

import java.util.concurrent.Future;

public interface BattleInterface {
    Future<Fighting> fight(Robot robot1, Robot robot2);

    void endBattle();
}
