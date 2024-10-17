package school.faang.supercow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private int maxPlayers = 5;
    private int currentPlayers;
    private int timeBetweenAttempts = 150;

    public synchronized void joinBattle(Player player)
                                                 throws InterruptedException {
        if (currentPlayers >= maxPlayers) {
            while (currentPlayers >= maxPlayers) {
                System.out.println("Слышь, " + player.getName() +
                        ", против босса и так сражается целая пати, " +
                        "подожди, пока он кого-то грохнет");
                wait(timeBetweenAttempts);
                System.out.println(player.getName() +
                        " снова пытается агрить босса");
            }
            System.out.println(player.getName() + " все-таки заагрил босса");

        } else {
            currentPlayers ++;
            System.out.println(player.getName() + " заагрил босса и вступил в битву");
        }
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " расчленен и выпотрошен");
        currentPlayers --;
        this.notifyAll();
    }

}
