package school.faang_sprint_3.supercow;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        var boss = new Boss();
        var archer = new Player("Archer");
        var druid = new Player("Druid");
        var sorcery = new Player("Sorcery");

        var threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(() -> archer.startBattle(boss));
        threadPool.submit(() -> druid.startBattle(boss));
        threadPool.submit(() -> sorcery.startBattle(boss));
        threadPool.shutdown();
    }
}
