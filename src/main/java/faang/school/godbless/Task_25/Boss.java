package faang.school.godbless.Task_25;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Boss {
    int maxPlayers;
    int currentPlayers;

    void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers != maxPlayers) {
                System.out.println(player.getName() + " started battle");
                currentPlayers++;
                System.out.println(player.getName() + " finished battle");
                notify();
                currentPlayers--;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
