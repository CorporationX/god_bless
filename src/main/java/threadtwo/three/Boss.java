package threadtwo.three;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {

    private int maxPlayers;
    private int currentPlayer;
    private String name;
    private boolean isLobbyCreated;

    public Boss(int maxPlayers, String name) {
        this.maxPlayers = maxPlayers;
        this.name = name;
        this.currentPlayer = 0;
        this.isLobbyCreated = false;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayer == maxPlayers) {
                wait();
                System.out.println("Лобби полное. " +
                        "Вы в очереди на подключение.");
            }
            currentPlayer++;
            if (!isLobbyCreated && currentPlayer == 1) {
                System.out.println("Player " + player.getName() + " создал лобби.");
                System.out.println("Цель: Победить босса " + name);
                isLobbyCreated = true;
            } else {
                System.out.println("Player " + player.getName() + " присоединился.");
                System.out.println("Текущее число игроков в лобби:" + currentPlayer);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Подключение к лобби прервано.");
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayer > 0) {
            currentPlayer--;
            System.out.println(player.getName() + " вышел из лобби. " +
                    "Текущее число игроков: " + currentPlayer);
            notify();
        }
    }

    public synchronized boolean isLobbyCreated() {
        return isLobbyCreated;
    }


}
