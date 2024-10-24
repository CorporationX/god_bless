package school.faang.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Boss {
    private String name;
    private int maxPlayers;
    private int currentPlayers;

    public void printSlots(){
        System.out.println("Слоты: " + getCurrentPlayers() + "/" + getMaxPlayers());
        System.out.println();
    }

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        {
            if (maxPlayers <= currentPlayers) {
                System.out.println(player.getName() + " ждет свободного слота.");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к бивте с " + getName());
            printSlots();
            log.info("");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Игрок: " + player.getName() + " покинул бой.");
        notify();
        printSlots();
    }
}
