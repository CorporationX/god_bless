package school.faang.bjs249674;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private final int currentPlayers;

    public Boss(int currentPlayers, int maxPlayers) {
        this.currentPlayers = currentPlayers;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            //player.jion
        } else {
            //wait();
        }
    }
}
