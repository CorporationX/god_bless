package faang.school.godbless.sprint4.supercow.classes;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Boss {
    private final int MAX_PLAYERS;
    private int currentPlayers;

    @SneakyThrows
    public synchronized void joinBattle(Player player){
        while (currentPlayers >= MAX_PLAYERS){
            System.out.println("Boss is full. Player " + player.getName() + " is waiting");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " starting fight");
    }

    public synchronized void endBattle(){
        System.out.println("Boss is ending fight");
        currentPlayers--;
        notify();
    }
}
