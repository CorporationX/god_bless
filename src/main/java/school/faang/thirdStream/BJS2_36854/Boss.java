package school.faang.thirdStream.BJS2_36854;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (maxPlayers - currentPlayers == 0) {
            System.out.printf("Игрок '%s' ждёт своей очереди присоедениться к сражению%n", player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Потеря связи с игроком");
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.printf("Игрок '%s' присоединился к сражению%n", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("Игрок '%s' завершил сражение%n", player.getName());
        notify();
    }
}