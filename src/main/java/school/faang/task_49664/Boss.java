package school.faang.task_49664;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждёт свободного слота для сражения с боссом.");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению с боссом!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение с боссом!");
        notify();
    }
}
