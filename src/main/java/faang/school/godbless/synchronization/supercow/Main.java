package faang.school.godbless.synchronization.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss gwyn = new Boss(3, "Gwyn, Lord of Cinder");

        Player tarnished = new Player("Tarnished");
        Player chosenUndead = new Player("Chosen undead");
        Player hunter = new Player("Hunter");
        Player shinobi = new Player("Sekiro");

        ExecutorService battleThreadsPool = Executors.newCachedThreadPool();

        log.info("Players are starting the boss fight");

        battleThreadsPool.submit(() -> tarnished.startBattle(gwyn));
        battleThreadsPool.submit(() -> chosenUndead.startBattle(gwyn));
        battleThreadsPool.submit(() -> hunter.startBattle(gwyn));
        battleThreadsPool.submit(() -> shinobi.startBattle(gwyn));

        battleThreadsPool.shutdown();

        try {
            battleThreadsPool.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Something interrupted boss fight termination waiting.", e);
            return;
        }

        log.info("Boss fight has been successfully terminated");
    }
}
