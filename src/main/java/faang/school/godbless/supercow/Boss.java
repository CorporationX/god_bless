package faang.school.godbless.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player){
        while (currentPlayers >= maxPlayers){
            try {
                System.out.println("Нет свободных слотов для " + player.getName() + " |Ожидание...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению против босса");
    }

    public synchronized void endBattle(Player player){
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение.\nПоявился свободный слот");
        notifyAll();
    }
}
