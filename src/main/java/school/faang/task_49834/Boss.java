package school.faang.task_49834;

import lombok.*;

@Getter
@Setter
public class Boss {
    private Integer maxPlayers;
    private Integer currentPlayers;

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ожидает.......");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение с боссом!!!!!!");
        notify();
    }

    public Boss(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }
}
