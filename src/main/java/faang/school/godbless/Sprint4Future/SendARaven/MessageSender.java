package faang.school.godbless.Sprint4Future.SendARaven;

import java.util.concurrent.CompletableFuture;

public class MessageSender {

    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        Kingdom lanisters = new Kingdom("Lanisters");
        Kingdom starks = new Kingdom("Starks");

        CompletableFuture<U> uCompletableFuture = CompletableFuture.supplyAsync(() -> sender.sendRaven(lanisters, starks));

        sender.sendRaven(lanisters,starks);
        System.out.println(lanisters.getMessage());
        System.out.println(starks.getMessage());
    }

    public void sendRaven(Kingdom kingdomFrom, Kingdom kingdomTo){
        try {
            kingdomFrom.sendMessage(kingdomTo);
            System.out.println("Message delivered");
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
