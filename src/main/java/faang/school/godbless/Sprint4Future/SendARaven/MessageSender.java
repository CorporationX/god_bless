package faang.school.godbless.Sprint4Future.SendARaven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MessageSender {

    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        Kingdom lanisters = new Kingdom("Lanisters");
        Kingdom starks = new Kingdom("Starks");
        sender.sendRaven(lanisters,starks,"Hi Starks");
    }

    public CompletableFuture<String> sendRaven(Kingdom kingdomFrom, Kingdom kingdomTo, String message){
        CompletableFuture<String> sendingMessage = kingdomFrom.sendMessage(kingdomTo, message);
        try {
            System.out.println(sendingMessage.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return sendingMessage.handle((sentMessage, exception) -> {
            if (message != null){
                return message;
            } else {
                return exception.getMessage();
            }
        });
    }
}
