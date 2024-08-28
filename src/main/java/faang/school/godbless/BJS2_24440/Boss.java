package faang.school.godbless.BJS2_24440;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        System.out.println(player.getName() + " пытается присоединиться к сражению с боссом.");
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println("Все слоты заняты. " + player.getName() + " ждёт.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению!" +
                " Количество игроков в битве: " + currentPlayers + " , всего слотов: " + maxPlayers);
    }

    public void battle(Player player) {
        System.out.println(player.getName() + " сражается с боссом!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение. Освободился слот. Количество игроков: " + currentPlayers);
        notifyAll();
    }
}
