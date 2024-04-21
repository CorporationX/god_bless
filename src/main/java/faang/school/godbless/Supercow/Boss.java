package faang.school.godbless.Supercow;

class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting for a slot...");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle!");
    }

    public synchronized void finishBattle() {
        currentPlayers--;
        notify();
    }
}