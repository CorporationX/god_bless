package faang.school.godbless.multithreading.send_raven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Kingdom> kingdoms = List.of(
                new Kingdom("Far Far Away"),
                new Kingdom("Ebengrad"),
                new Kingdom("Middle-earth"),
                new Kingdom("Stark"));
        List<CompletableFuture<Void>> features = new ArrayList<>();

        for (int i = 1; i < kingdoms.size(); i++) {
            features.add(kingdoms.get(i - 1).sendRaven(kingdoms.get(i)));
        }

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                features.toArray(new CompletableFuture[0])
        );
        combinedFuture.join();
    }
}
