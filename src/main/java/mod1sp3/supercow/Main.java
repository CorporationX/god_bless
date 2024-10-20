package mod1sp3.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss bossRodger = new Boss(2);
        List<Player> playerList = new ArrayList<>(List.of(
                new Player("lexa123"),
                new Player("mighty-mhsl"),
                new Player("pearacle123"),
                new Player("regis"),
                new Player("geniusPlayer113337")
        ));

        for (Player player : playerList) {
            new Thread(() -> player.startBattle(bossRodger)).start();
        }
    }
}
