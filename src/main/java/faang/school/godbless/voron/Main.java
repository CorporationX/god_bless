package faang.school.godbless.voron;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Dorne");
        Kingdom kingdom2 = new Kingdom("Crownland");
        Kingdom kingdom3 = new Kingdom("Stormlands");
        Kingdom kingdom4 = new Kingdom("Riverlands");

        sendRaven(kingdom1, kingdom2, "Hello world!");
        sendRaven(kingdom4, kingdom3, "Hello everyone!");
    }

    public static void sendRaven(Kingdom kingdomReceiver, Kingdom kingdomSender, String message) {
        CompletableFuture<String> future = kingdomSender.sendMessage(kingdomSender, message)
                .handle((msg, exc) -> {
                        if (exc != null) {
                            return "Message was lost...";
                        } else {
                            return "'" + msg + "'" + " has been delivered to " + kingdomReceiver.getName();
                        }
                });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
