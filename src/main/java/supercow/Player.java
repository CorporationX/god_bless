package supercow;

import lombok.Data;

@Data
public class Player implements Runnable {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Start a battle with the given boss. This method blocks until the battle
     * is finished.
     *
     * @param boss the boss to battle
     * @throws InterruptedException if the thread is interrupted while waiting
     * for the battle to finish
     */
    public void startBattle(Boss boss) throws InterruptedException {
        System.out.println(name + " сражается с боссом...");
        Thread.sleep(3000);
        boss.leaveBattle(this);
    }

    /**
     * Runs the player's thread, which joins a battle with the boss.
     *
     * This method is called by the player's thread and should not be
     * called directly. It blocks until the battle is finished.
     *
     * @implNote This implementation catches {@link InterruptedException}
     * and interrupts the thread to properly handle thread interruption.
     * @see Thread#interrupt()
     */
    @Override
    public void run() {
        try {
            Boss battleBoss = BattleSimulation.getBoss();
            battleBoss.joinBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
