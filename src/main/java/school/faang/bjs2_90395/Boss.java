package school.faang.bjs2_90395;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                log.info("игрок {} ждет освобождения лишнего слота для боя с боссом", player.getName());
                this.wait();
            } catch (InterruptedException e) {
                log.info("игрок не дождался освобождения слота для битвы с боссом.");
                Thread.currentThread().interrupt();
            }
        }
        log.info("игрок {} вступает в бой с боссом", player.getName());
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        log.info("игрок {} выходит из лобби и освобождает занятый слот", player.getName());
        currentPlayers--;
        this.notifyAll();
    }
}
