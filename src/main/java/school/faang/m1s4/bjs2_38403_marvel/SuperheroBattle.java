package school.faang.m1s4.bjs2_38403_marvel;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
public class SuperheroBattle {
    private static final int TERMINATION_SECONDS = 300;
    private static final int N_POOLS = 8;
    private Random random = new Random();
    private final ExecutorService service = Executors.newFixedThreadPool(N_POOLS);
    private Fight fight = new Fight();

    public void runTournament(List<Superhero> participants) {
        log.info("WELCOME");
        log.info("!!!Ultimate Marvel Championship begins!!!");
        System.out.println();
        sleep(6000);

        List<Superhero> fighters = participants;

        while (fighters.size() > 2) {
            log.info("1/{} finals begins", fighters.size());

            announceHeroes(fighters);

            sleep(5000);

            List<CompletableFuture<Superhero>> futureFights = runStage(fighters);

            fighters = proceedStage(futureFights);

            System.out.println();
        }

        fightFinal(fighters);

        shutdownPool();
    }

    private List<Pair<Superhero, Superhero>> createPairs(List<Superhero> heroesList) {
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();

        while (!heroesList.isEmpty()) {
            pairs.add(new Pair<>(
                    heroesList.remove(random.nextInt(heroesList.size())),
                    heroesList.remove(random.nextInt(heroesList.size()))
            ));
        }
        return pairs;
    }

    private List<CompletableFuture<Superhero>> runStage(List<Superhero> heroesList) {
        return createPairs(heroesList).stream()
                .map(pair ->
                        CompletableFuture.supplyAsync(() ->
                                fight.fight(pair.getFirst(), pair.getSecond()), service)
                )
                .toList();
    }

    private List<Superhero> proceedStage(List<CompletableFuture<Superhero>> tasks) {
        List<Superhero> survivors = new ArrayList<>();

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        tasks.forEach(task -> survivors.add(task.join()))
                ).join();
        return survivors;
    }

    private void announceHeroes(List<Superhero> heroes) {
        log.info("Participants: ");
        heroes.forEach(superhero -> log.info(superhero.getName()));
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }

    private void fightFinal(List<Superhero> heroes) {
        log.info("INTERGALACTIC MARVEL CHAMPIONSHIP FINAL BEGINS");
        System.out.println();
        sleep(4000);
        Superhero winner = proceedStage(runStage(heroes)).get(0);
        System.out.println();
        sleep(4000);
        log.info("THE CHAMPION IS....");
        log.info("*** {} ***", winner.getName().toUpperCase());
    }

    private void shutdownPool() {
        service.shutdown();
        try {
            if (!service.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}