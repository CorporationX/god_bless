package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss bigBoss = new Boss(4);
        List<Player> players = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            players.add(new Player(String.valueOf(i)));
        }

        players.forEach(player -> new Thread(() -> {
            try {
                player.startBattle(bigBoss);

            } catch (InterruptedException e) {
                throw new IllegalStateException("Поток содержит ошибку " + e.getMessage());
            }
        }).start());

    }
}
