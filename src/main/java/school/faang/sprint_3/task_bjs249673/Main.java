package school.faang.sprint_3.task_bjs249673;

import java.util.List;

public class Main {
    private static final String BOSS_NAME = "Big Boss";
    private static final int BOSS_MAX_PLAYERS = 3;
    private static final int NUMBER_OF_PLAYERS = 7;

    public static void main(String[] args) {
        Boss boss = new Boss(BOSS_NAME, BOSS_MAX_PLAYERS);
        List<Player> players = TestDataGenerator.getPlayers(NUMBER_OF_PLAYERS);
        List<Thread> playerThreads = TestDataGenerator.getPlayersStartBattleThreads(players, boss);
        playerThreads.forEach(Thread::start);
    }
}
