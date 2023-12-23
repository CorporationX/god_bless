package faang.school.godbless.Supercow;

import lombok.Getter;


@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (maxPlayers > currentPlayers) {
            currentPlayers++;
            System.out.println("Iгрок " + player.getName() + " присоединился к сражению с боссом");
        } else {
            System.out.println("Iгрок " + player.getName() + " в ожидании");
            this.wait();
        }
    }

    public synchronized void endBattle(Player player) {
        System.out.println("Iгрок " + player.getName() + " завершил сражение с боссом");
        currentPlayers--;
        this.notify();
    }
}
