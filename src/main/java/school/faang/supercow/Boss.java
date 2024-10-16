package school.faang.supercow;

public class Boss {

    private final int maxPlayers = 3;
    private final Player[] currentPlayers = new Player[maxPlayers];
    private int playerCount = 0;

    public synchronized void joinBattle(Player player) {
        while (playerCount == maxPlayers) {
            try {
                System.out.println("Все слоты заняты, игрок " + player.getName() + " ждет.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (int i = 0; i < maxPlayers; i++) {
            if (currentPlayers[i] == null) {
                currentPlayers[i] = player;
                playerCount++;
                System.out.println("Игрок " + player.getName() + " присоединяется к битве!!");
                break;
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        for (int i = 0; i < maxPlayers; i++) {
            if (currentPlayers[i] == player) {
                currentPlayers[i] = null;
                playerCount--;
                System.out.println("Игрок " + player.getName() + " покинул сражение!");
                break;
            }
        }
        notifyAll();
    }
}
