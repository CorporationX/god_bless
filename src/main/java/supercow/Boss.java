package supercow;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {

    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.printf("\nPlayer %s start the battle", player.getName());
    }

    public synchronized void finishBattle(Player player){
        currentPlayers--;
        System.out.printf("\nPlayer %s finished the battle", player.getName());
        this.notifyAll();
    }
}
