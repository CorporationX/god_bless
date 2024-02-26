package faang.school.godbless.supercow2972;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
public class Boss {
    private final int MAX_PLAYERS;
    @Setter
    private int currentPlayers;
    private static final Random RANDOM = new Random();

    public Boss(int MAX_PLAYERS) {
        this.MAX_PLAYERS = MAX_PLAYERS;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            if (this.getCurrentPlayers() == this.getMAX_PLAYERS()) {
                this.wait();
            }
            this.setCurrentPlayers(this.getCurrentPlayers() + 1);
            System.out.printf("Battle begins! %s is fighting Boss%n", player.getName());
            System.out.println("Players battling: " + this.getCurrentPlayers());
        }
        Thread.sleep(RANDOM.nextLong(10000, 20000));
        synchronized (this) {
            this.setCurrentPlayers(this.getCurrentPlayers() - 1);
            System.out.printf("%s left the Arena.%n", player.getName());
            this.notify();
        }
    }
}
