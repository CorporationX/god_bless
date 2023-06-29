package faang.school.godbless.Supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Boss {
    @NonNull
    private Integer maxPlayers;
    private int currentPlayers;

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ожидает");
            wait();
        }
        currentPlayers++;
        player.setConnected(true);
        System.out.println(player.getName() + " занял слот");

    }

    public synchronized void finishBattle(Player player) {
        currentPlayers--;
        System.out.printf("%s has finished the battle\n", player.getName());
        notify();
    }
}
