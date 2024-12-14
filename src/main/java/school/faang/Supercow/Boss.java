package school.faang.Supercow;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Semaphore;

@Getter
@Setter
public class Boss {
    private String name;
    Semaphore playersBox;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.playersBox = new Semaphore(maxPlayers);
    }

    public void joinBattle(Player player) {
        try {
            System.out.println(player.getName() + " trying to start the battle");
            playersBox.acquire();
            System.out.println(player.getName() + " started battle with " + name);
        } catch (InterruptedException e) {
            playersBox.release();
            throw new IllegalStateException(e);
        }
    }

    public void endBattle(Player player) {
        System.out.println(player.getName() + " ended battle with " + name);
        playersBox.release();
    }

}
