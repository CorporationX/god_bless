package faang.school.godbless.sendCrow;

import lombok.Data;

import java.util.concurrent.CompletableFuture;

@Data
public class Kingdom {
    private String name;

    public Kingdom(String name) {
        this.name = name;
    }

    public CompletableFuture<String> sendMessage(Kingdom recipient) {
        System.out.println("Sending a raven from " + this.name + " to " + recipient.getName());

        return CompletableFuture.supplyAsync(() -> {
            boolean messageDelivered = true;

            if (messageDelivered) {
                return "Message delivered successfully";
            } else {
                throw new RuntimeException("Failed to deliver message");
            }
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Error while sending a raven: " + ex.getMessage());
                return "Error: " + ex.getMessage();
            } else {
                System.out.println("Crow successfully delivered: " + result);
                return result;
            }
        });
    }
}
