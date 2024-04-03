package supercow;

import lombok.SneakyThrows;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    @SneakyThrows
    public synchronized void joinBattle(Player player){
        while (maxPlayers <= currentPlayers){
            System.out.println(player.getName() + " ожидайте, босса уже запинывает много игроков");
            wait();
        }
        ++currentPlayers;
        System.out.println(player.getName() + "сражается с боссом");
    }
    public synchronized void endBattle (Player player){
        --currentPlayers;
        System.out.println(player.getName() + "отпинать ,басса не получилось, за то вас да -- Game over");
        notify();
    }
}
