package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task04_SuperCow;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Boss {
    private final int MAX_PLAYERS;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers > MAX_PLAYERS) {
            System.out.println("There is a boss fight." + player.getName() + " player is waiting");
            wait();
        }
        currentPlayers++;
        System.out.println("The " + player.getName() + " joined the game to fight the boss");
    }
    public synchronized void endBattle(){
        System.out.println("Bossfight is ending");
        currentPlayers--;
        notify();
    }
}
