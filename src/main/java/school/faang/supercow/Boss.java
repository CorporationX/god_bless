package school.faang.supercow;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;


    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            log.info("Игрок {} в очереди для боя с боссом.", player.getName());
            wait();
        }
        currentPlayers++;
        log.info("Игрок {} присоединился к битве c боссом! Игроков в бою: {}/{}",
                player.getName(), currentPlayers, maxPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Игрок {} покинул битву c боссом. Игроков в бою: {}/{}",
                player.getName(), currentPlayers, maxPlayers);
        notifyAll();
    }

}
