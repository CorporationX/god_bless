package school.faang.superCow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private final Integer maxPlayers;
    private Integer currentPlayers = 0;

    public Boss(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (this.currentPlayers >= this.maxPlayers) {
                System.out.println("Игрок " + player.getName() + " ждет");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println("Игрок " + player.getName() + " Присоеднился к сражению");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            System.out.println("Игрок " + player.getName() + " Покинул сражение");
            currentPlayers--;
            notify();
        }
    }


}
