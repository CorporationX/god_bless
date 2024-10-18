package school.faang.BJS236776;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    Boss(int maxPlayers) {
        this.currentPlayers = 0;
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " | Все слоты заняты, жди!");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " | Присоединился к битве!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " | Вышел с боя!");
        currentPlayers--;
        notify();
    }
}
