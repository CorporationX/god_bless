package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task5;

public class Boss {
    private int maxPlayers;

    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ожидает битвы");
            wait();
        }
        currentPlayers++;
        System.out.println("Игроков в бою: j" + currentPlayers);
        System.out.println(player.getName() + " присоединился к битве");
    }

    public synchronized void deleteBattle(Player player) throws InterruptedException {
        currentPlayers--;
        System.out.println("Игроков в бою: D" + currentPlayers);
        System.out.println(player.getName() + " покинул битву с боссом");
        notifyAll();
    }
}
