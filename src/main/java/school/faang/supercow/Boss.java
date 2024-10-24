package school.faang.supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private int maxPlayers, currentPlayers;

    public synchronized void joinBattle(Player player) {
        System.out.println(player.getName() + " is trying to join the battle");

        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println("Lobby is full for now. Please wait your turn to join the battle\n");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " joined\n");
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            System.out.println(player.getName() + " has left the battle.\n");
            this.notify();
        }
    }
}
