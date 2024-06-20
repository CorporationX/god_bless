package faang.school.godbless.multithreading.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Boss {

    private int maxPlayers;

    private int currentPlayers;

    public void joinBottle(Player player) throws InterruptedException {
        synchronized (this) {
            if (currentPlayers == maxPlayers) {
                this.wait();
            }
            currentPlayers++;
        }

        System.out.println(player + " сражается c боссом");
        Thread.sleep(3000);
        System.out.println("\t" + player + " закончил бой");

        synchronized (this) {
            currentPlayers--;
            this.notify();
        }
    }
}