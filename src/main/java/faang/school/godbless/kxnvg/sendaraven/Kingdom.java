package faang.school.godbless.kxnvg.sendaraven;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class Kingdom {

    private String name;

    public static void main(String[] args) {
        Kingdom northern = new Kingdom("Северное");
        Kingdom rocks = new Kingdom("Королесвто Скал");

        CompletableFuture<String> completableFuture = sendRaven(northern, rocks);
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        CompletableFuture<String> sendMessage = sender.sendMessage(receiver);
        sendMessage.handle((message, exception) -> {
            if (message == null) {
                return exception.getMessage();
            } else {
                return message;
            }
        });
        return sendMessage;
    }

    private CompletableFuture<String> sendMessage(Kingdom kingdom) {
        CompletableFuture<String> kingdomFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Math.random() > 0.2) {
                return "Сообщение доставлено в королевство " + kingdom.name;
            } else {
                throw new RuntimeException("К сожалению сообщение не удалось доставть до королества" + kingdom.name);
            }
        });
        return kingdomFuture;
    }
}
