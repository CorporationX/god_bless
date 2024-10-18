package supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * This method allows the given player to join the battle. It waits until
     * there is a free slot in the battle and then starts the battle for the
     * player. It prints a message when the player joins or leaves the battle.
     *
     * @param player the player that wants to join the battle
     * @throws InterruptedException if this thread is interrupted while waiting
     */
    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет своей очереди присоединиться к битве.");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к битве! Сейчас в бою: " + currentPlayers + " игрок(ов).");
        player.startBattle(this);
    }

    /**
     * This method is called by a player when it wants to leave the battle. It
     * decreases the count of players in the battle and notifies all waiting
     * threads (i.e. players waiting to join the battle) that a slot is free.
     *
     * @param player the player that wants to leave the battle
     */
    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение. Сейчас в бою: " + currentPlayers + " игрок(ов).");
        notify();
    }
}
