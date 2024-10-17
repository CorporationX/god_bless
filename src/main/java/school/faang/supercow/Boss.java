package school.faang.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lockerJoinBattle;

    public Boss(int maxPlayers, Object lockerJoinBattle) {
        this.maxPlayers = maxPlayers;
        this.lockerJoinBattle = lockerJoinBattle;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lockerJoinBattle) {
            while (currentPlayers >= maxPlayers) {
                try {
                    lockerJoinBattle.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Произошла ошибка в методе joinBattle, при ожидании места", e);
                }
            }
            System.out.println("attack " + player.name());
            currentPlayers++;
        }
    }

    public void timeOutOf() {
        synchronized (lockerJoinBattle){
            currentPlayers--;
            lockerJoinBattle.notify();
        }
    }

}
