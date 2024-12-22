package school.faang.sprint3.bjs_49720;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (maxPlayers <= currentPlayers) {
            this.wait();
        }
        currentPlayers++;
        System.out.println(String.format("Игрок %s добавлен в сражение", player.getName()));
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(String.format("Игрок %s закончил сражение", player.getName()));
        this.notify();
    }
}
