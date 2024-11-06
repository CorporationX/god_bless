package ravens_letter;

import java.util.concurrent.CompletableFuture;

public class Kingdom {
    private String name;

    public Kingdom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.3) {
            throw new RavenDeliveryException("Raven was unable to deliver a message from "
                    + name + " to " + receiver.getName());
        }
        return "Send letter from " + name + " to " + receiver.getName();
    }
}


