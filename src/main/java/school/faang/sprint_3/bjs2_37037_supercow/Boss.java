package school.faang.sprint_3.bjs2_37037_supercow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            log.info("Игрок {} ожидает свободный слот для сражения с боссом.", player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Произошла ошибка при ожидании свободного слота.");
                throw new RuntimeException(e);
            }
        }

        currentPlayers++;
        log.info("{} присоединился к сражению с боссом!", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("{} покинул сражение, место освободилось!", player.getName());
        notify();
    }
}
