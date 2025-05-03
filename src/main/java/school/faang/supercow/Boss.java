package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("{} ждет, чтобы присоединиться к битве", player.getName());
            wait();
        }
        currentPlayers++;
        log.info("{} присоединился к битве с боссом: Текущие игроки {}", player.getName(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("{} покинул битву с боссом. Текущие игроки: {}", player.getName(), currentPlayers);
        notify();
    }
}