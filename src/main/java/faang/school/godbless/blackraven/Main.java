package faang.school.godbless.blackraven;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");
        KingdomService kingdomService = new KingdomService();

        CompletableFuture<Void> firstAttempt = kingdomService.sendRaven(kingdom1, kingdom2);
        CompletableFuture<Void> secondAttempt = kingdomService.sendRaven(kingdom2, kingdom1);
        CompletableFuture<Void> thirdAttempt = kingdomService.sendRaven(kingdom1, kingdom2);
        CompletableFuture<Void> fourthAttempt = kingdomService.sendRaven(kingdom2, kingdom1);
        CompletableFuture.allOf(firstAttempt, secondAttempt, thirdAttempt, fourthAttempt).join();

        kingdomService.shutdownAndAwaitExecution(5L);
    }
}