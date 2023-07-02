package faang.school.godbless.threads.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int maxPlayers;
    private int count;
    private final Integer currentPlayers = Integer.valueOf(count);

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.count = 0;
    }

    public void joinBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers == maxPlayers) {
                System.out.println("Ожидаем, когда освободится слот ...");
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count++;
            System.out.println("Присоединился игрок " + player.getName());
        }
    }

    public void reducePlayer(Player player) {
        synchronized (currentPlayers) {
            count--;
            System.out.println("Игрок " + player.getName() + " вышел из игры");
        }
    }
}
