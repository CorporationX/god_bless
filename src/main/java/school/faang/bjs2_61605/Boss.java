package school.faang.bjs2_61605;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Boss {

    private final Object lock = new Object();

    private final int maxPlayers = 2;
    private int currentPlayers;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                System.out.println("Все слоты заняты, необходимо подождать...");
                lock.wait();

            }
            currentPlayers++;
            System.out.printf("Игрок %s присоединился к битве с боссом %n", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("Игрок %s покидает битву %n", player.getName());
            lock.notifyAll();
        }
    }

}
