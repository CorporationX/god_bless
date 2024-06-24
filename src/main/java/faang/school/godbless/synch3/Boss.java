package faang.school.godbless.synch3;

public class Boss {
    private static final long BATTLE_TIME = 2000L;
    private static final String MESSAGE_JOIN_BATTLE = "%s вступил в сражение с боссом\n";
    private static final String MESSAGE_BATTLE_FULL = "Нет свободного места в сражении";
    private static final String MESSAGE_LEAVE_BATTLE = "%s закончил сражение с боссом\n";
    private static final String ERROR = "Сражение прервалось: ";
    private static final int START_CURRENT_PLAYERS = 0;
    private final int maxPlayers;
    private final Object lock;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.lock = new Object();
        this.currentPlayers = START_CURRENT_PLAYERS;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                System.out.println(MESSAGE_BATTLE_FULL);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.format(MESSAGE_JOIN_BATTLE, player.name());
        }
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
    }

    public synchronized void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.format(MESSAGE_LEAVE_BATTLE, player.name());
            lock.notify();
        }
    }
}
