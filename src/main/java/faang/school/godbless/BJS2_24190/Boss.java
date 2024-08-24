package faang.school.godbless.BJS2_24190;

public class Boss {
    private int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " ожидает присоединения к битве.");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к битве\n ----------"); // ------- для удобства, что бы понимать когда игрок присоединился
        }
    }

    public void finishedBattle(Player player) {
        synchronized (this) {
            currentPlayers--;
            System.out.println(player.getName() + " закончил битву");
            notify();
        }
    }

}
