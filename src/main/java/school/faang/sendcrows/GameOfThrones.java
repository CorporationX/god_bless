package school.faang.sendcrows;

import java.util.concurrent.CompletableFuture;

public class GameOfThrones {

    public static void main(String[] args) {

        Kingdom winterfell = new Kingdom("Винтерфелл");
        Kingdom kingsLanding = new Kingdom("Королевская Гавань");
        Kingdom highgarden = new Kingdom("Хайгарден");

        RavenService ravenService = new RavenService();

        CompletableFuture<Void> future1 = ravenService.sendRaven(winterfell, kingsLanding);
        CompletableFuture<Void> future2 = ravenService.sendRaven(highgarden, winterfell);
        CompletableFuture<Void> future3 = ravenService.sendRaven(kingsLanding, highgarden);

        CompletableFuture.allOf(future1, future2, future3).join();

        System.out.println("Все сообщения были обработаны.");
    }
}
