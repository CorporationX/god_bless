package faang.school.godbless.BJS224326;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    List<Player> list = new ArrayList<>(maxPlayers);

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            if (list.size() == maxPlayers) {
                this.wait();
            }
        }
        list.add(player);
        Thread.sleep(2000);
        System.out.println("    ");
        synchronized (this){
            this.notifyAll();
        }
    }




}
