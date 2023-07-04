import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KingdomMain {
    public static CompletableFuture sendRaven(Kingdom senderKingdom, Kingdom receiverKingdom, String message, boolean isThrow) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                senderKingdom.sendMessage(receiverKingdom, message);
                Thread.sleep(1000);
                if (!isThrow) {
                    throw new RuntimeException("Сообщение " + message + " не доставлено в королевство: " + receiverKingdom.getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Сообщение " + message + " доставлено в королевство: " + receiverKingdom.getName();
        }).handle((res, ex) -> {
            if (ex != null) {
                return ex.getMessage();
            }
            return res;
        });

        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException {
        Kingdom firstKingdom = new Kingdom("Novigrad");
        Kingdom secondKingdom = new Kingdom("Oxenfurt");
        Kingdom thirdKingdom = new Kingdom("Vizima");
        Kingdom fourthKingdom = new Kingdom("Kaer Morhen");

        CompletableFuture<String> firstSend = sendRaven(firstKingdom, secondKingdom, "Hello", true);
        CompletableFuture<String> secondSend = sendRaven(thirdKingdom, fourthKingdom, "Message", false);

        try {
            System.out.println(firstSend.get());
            System.out.println(secondSend.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
