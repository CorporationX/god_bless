package faang.school.godbless.Sprint4Future.SendARaven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MessageSender {

    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        Kingdom lanisters = new Kingdom("Lanisters");
        Kingdom starks = new Kingdom("Starks");
        CompletableFuture<String> hiStarks = sender.sendRaven(lanisters, starks, "Hi Starks");
        try {
            System.out.println(hiStarks.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<String> sendRaven(Kingdom kingdomFrom, Kingdom kingdomTo, String message){
        CompletableFuture<String> sendingMessage = kingdomFrom.sendMessage(kingdomTo, message);
        return sendingMessage.handle((sentMessage, exception) -> {
            if (sentMessage != null){
                return sentMessage;
            } else {
                return exception.getMessage();
            }
        });
    }
}
