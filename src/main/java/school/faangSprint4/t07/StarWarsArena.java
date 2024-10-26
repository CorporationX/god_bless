package school.faangSprint4.t07;

import java.util.List;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        List<Robot> robots = List.of(
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 6)
        );

        BattleManager manager = new BattleManager(battle, robots);
        manager.arrangeBattles();
        manager.displayResults();
    }
}