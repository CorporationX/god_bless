package faang.school.godbless.SendRaven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        List<Kingdom> kingdoms = getKingdoms();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < kingdoms.size(); i++) {
            for (int j = 0; j < kingdoms.size(); j++) {
                if (j != i) {
                    futures.add(sendRaven(kingdoms.get(i), kingdoms.get(j), pool)
                            .handle((mes, exc) -> exc == null ? mes : exc.getMessage())
                            .thenAccept(System.out::println)
                    );
                }
            }
        }

        pool.shutdown();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
    }

    private static CompletableFuture<String> sendRaven(Kingdom from, Kingdom to, ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new RavenIsMissingException("Raven was lost during the adventure from " + from.getName() + " to " + to.getName());
            }
            return from.sendMessage(to);
        }, pool);
    }

    private static List<Kingdom> getKingdoms() {
        List<Kingdom> kingdoms = new ArrayList<>();
        kingdoms.add(new Kingdom("The Kingdom of Aksum"));
        kingdoms.add(new Kingdom("The Vandal and Alan Kingdom"));
        kingdoms.add(new Kingdom("Visigothic Kingdom"));
        kingdoms.add(new Kingdom("Frankish Kingdom"));
        kingdoms.add(new Kingdom("Anglo-Saxon Kingdom"));
        return kingdoms;
    }
}
