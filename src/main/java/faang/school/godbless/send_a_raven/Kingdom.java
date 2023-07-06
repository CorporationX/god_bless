package faang.school.godbless.send_a_raven;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(String message, Kingdom kingdom) {
        return this.getName() + " sent a letter: " + message + " to " + kingdom.getName();
    }

    public static CompletableFuture<String> sendRaven(Kingdom kingdomSender, Kingdom kingdomRecipient) {
        CompletableFuture<String> sendResult = CompletableFuture.supplyAsync(() -> {
            Random didRavenDeliver = new Random();
            if(didRavenDeliver.nextBoolean()) {
                try {
                    Thread.sleep((long)(Math.random() * 10) * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return kingdomSender.sendMessage("Hello", kingdomRecipient);
            } else {
                throw new RuntimeException();
            }
        }).handle((result, exception) -> {
            if(result != null) {
                System.out.println("Message " + kingdomSender.getName() + " was delivered");
                return result;
            } else {
                System.out.println("The raven failed to deliver the letter from " + kingdomSender.getName());
                return "Error";
            }
        });
        return sendResult;
    }
}
