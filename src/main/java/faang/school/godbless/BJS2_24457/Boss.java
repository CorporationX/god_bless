package faang.school.godbless.BJS2_24457;

import lombok.Data;

@Data
public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " не может присоединиться, мест нет. Ожидание...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.printf("игрок %s присоединился к сражению\n", player.getName());
    }

    public synchronized void disconnectBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " закончил сражаться, место свободно.");
        notifyAll();
    }
}
