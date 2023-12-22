package faang.school.godbless.supercow;

import lombok.SneakyThrows;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        while (maxPlayers <= currentPlayers) {
            wait();
            System.out.println(player.getName() + " ожидает слот");
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединяется к бою. Количество игроков " + currentPlayers);
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил бой. Количество игроков " + currentPlayers);
        notifyAll();
    }

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
