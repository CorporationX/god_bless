package faang.school.godbless.raven_sender;

import java.util.concurrent.CompletableFuture;

public class RavenSender {

    public static void main(String[] args) {

        Kingdom castleBlack = new Kingdom("Castle Black");
        Kingdom dorne = new Kingdom("Dorne");
        String message = "Winter is coming";

        CompletableFuture<Void> future = castleBlack.sendRaven(dorne, message);
        future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Failed to deliver the message: " + ex.getMessage());
            } else {
                System.out.println("Message delivered successfully");
            }

            return null;
        });

        future.join();
    }
}
