package school.faang.supercow;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Boss {
    private final int maxPlayer;
    private final Object look = new Object();
    private int currentPlayers = 0;

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (look) {
            if (currentPlayers >= maxPlayer) {
                System.out.println("Нет свободных мест\n");
                look.wait();
            } else {
                currentPlayers++;
                System.out.printf("Добавлен игрок %s, теперь игроков: %d\n", player.name(), currentPlayers);
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (look) {
            if (currentPlayers < 0) {
                System.out.println("Невозможная операция, игроков и так нет");
            } else {
                currentPlayers--;
                System.out.printf("Есть свободное место, %s покидает битву\n", player.name());
                look.notify();
                System.out.println("Уведомили очередь\n");
            }
        }
    }
}
