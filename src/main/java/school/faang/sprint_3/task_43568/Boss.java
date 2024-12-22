package school.faang.sprint_3.task_43568;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Поток бsk прерван во время ожидания");
            }
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
