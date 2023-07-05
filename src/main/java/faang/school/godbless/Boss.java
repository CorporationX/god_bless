package faang.school.godbless;

public class Boss {
    private final int maxPlayers;
    private static int currentPlayers;

    public Boss(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player){
        if (currentPlayers < maxPlayers){
            currentPlayers++;
            System.out.println(player.getName() + " join the battle. CurrentPlayers: " + currentPlayers);
        } else {
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void deleteBattle(Player player)  {
        currentPlayers--;
        System.out.println(player.getName() + " exit battle. CurrentPlayers:  " + currentPlayers);
        notifyAll();
    }
}
