package faang.school.godbless.awesome_game;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreeLittlePigs {

    @SneakyThrows
    public static void main(String[] args) {

        Pig1Thread nifNif = new Pig1Thread("Nif-Nif", "straw");
        Pig2Thread nafNaf = new Pig2Thread("Naf-Naf", "grass and sticks");
        Pig3Thread nufNuf = new Pig3Thread("Nuf-Nuf", "bricks");

        List<PigThread> swines = List.of(nifNif, nafNaf, nufNuf);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (var swine: swines) {
            executor.submit(swine);
        }

        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("\nSuccess! Pigs are safe now!");
        executor.shutdown();
    }
}