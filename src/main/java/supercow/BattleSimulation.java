package supercow;

import java.util.List;

public class BattleSimulation {
    private static final Boss boss = new Boss(3);

    /**
     * Returns the single instance of the {@link Boss} class.
     *
     * @return The single instance of the {@link Boss} class.
     */
    public static Boss getBoss() {
        return boss;
    }

    /**
     * Simulates a battle of {@link Player}s with a single {@link Boss}.
     * <p>
     * The number of players is not limited by the number of slots available in the battle.
     * <p>
     * The threads are started in the order they are added to the list. The threads are joined
     * in the order they finish.
     * <p>
     * The program exits after all threads have finished.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        List<Thread> players = List.of(
                new Thread(new Player("Игрок 1")),
                new Thread(new Player("Игрок 2")),
                new Thread(new Player("Игрок 3")),
                new Thread(new Player("Игрок 4")),
                new Thread(new Player("Игрок 5"))
        );

        players.forEach(Thread::start);

        players.forEach(player -> {
            try {
                player.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println("Все игроки завершили сражение.");
    }
}
