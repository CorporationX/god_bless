package school.faang.BJS2_61598;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    @Getter
    private final String name;
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                System.out.printf("Места для битвы с %s заполнены. Ожидайте...\n", name);
                this.wait();
            } catch (InterruptedException e) {
                System.err.println("Произошла ошибка при ожидании места в битве.");
                return;
            }
        }
        currentPlayers++;
        System.out.printf("Игрок %s вступил в битву против %s.\n", player.getName(), name);

    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("Игрок %s покинул битву.\n", player.getName());
        this.notify();
    }
}
