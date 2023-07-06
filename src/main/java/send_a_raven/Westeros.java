package send_a_raven;

import java.util.concurrent.CompletableFuture;

public class Westeros {
    public static void main(String[] args) {
        Kingdom north = new Kingdom("North");
        Kingdom ironIslands = new Kingdom("Iron Islands");
        Kingdom arrenValley = new Kingdom("Arren Valley");
        Kingdom dorn = new Kingdom("Dorn");

        RavenManager ravenManager = new RavenManager();

        CompletableFuture<Object> raven1 = ravenManager.sendRaven(north, arrenValley);
        CompletableFuture<Object> raven2 = ravenManager.sendRaven(dorn, arrenValley);
        CompletableFuture<Object> raven3 = ravenManager.sendRaven(ironIslands, north);
        CompletableFuture<Object> raven4 = ravenManager.sendRaven(arrenValley, arrenValley);
        CompletableFuture<Object> raven5 = ravenManager.sendRaven(north, dorn);

        CompletableFuture.allOf(raven1, raven2, raven3, raven4, raven5)
                .thenRun(() -> {
                    System.out.println("\nAll ravens finished\n");
                    System.out.println(arrenValley.getName() + "'s messages for today - " + arrenValley.getMessages());
                    System.out.println(north.getName() + "'s messages for today - " + north.getMessages());
                    System.out.println(ironIslands.getName() + "'s messages for today - " + ironIslands.getMessages());
                    System.out.println(dorn.getName() + "'s messages for today - " + dorn.getMessages());
                    System.exit(0);
                });
    }
}
