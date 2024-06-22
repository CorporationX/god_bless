package faang.school.godbless.module1.sprint3.task10;

import java.util.Arrays;
import java.util.Objects;

public class Boss {
    private final Player[] currentPlayers;

    public Boss(int maxPlayers) {
        this.currentPlayers = new Player[maxPlayers];
    }


    public void joinBattle(Player player) throws InterruptedException {
        synchronized (currentPlayers) {
                if (!checkFreeSlot()){
                    currentPlayers.wait();
                }
                process(player);

        }
    }

    private boolean checkFreeSlot() {
        return Arrays.stream(currentPlayers).anyMatch(Objects::isNull);
    }

    private void process(Player player){
        for (int i = 0; i < currentPlayers.length; i++) {
            if (currentPlayers[i] == null) {
                currentPlayers[i] = player;
                System.out.println(currentPlayers[i] + " add in battle");
                break;
            }
        }
    }

    public void battleOver(Player player) {
        synchronized (currentPlayers) {
            for (int i = 0; i < currentPlayers.length; i++) {
                if (currentPlayers[i] == player) {
                    System.out.println(currentPlayers[i] + " leave battle");
                    currentPlayers[i] = null;
                    currentPlayers.notify();
                    break;
                }
            }
        }
    }
}
