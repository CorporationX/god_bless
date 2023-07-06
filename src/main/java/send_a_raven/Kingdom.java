package send_a_raven;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Kingdom {
    private String name;

    private List<String> messages;

    public Kingdom(String name) {
        this.messages = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void sendMessage(Kingdom recipientKingdom) {
        recipientKingdom.addMessage("Message from " + this.name);
        System.out.println("Message sent from " + this.name + " to " + recipientKingdom.name);
        waitForRavenFly();
    }

    private synchronized void addMessage(String message) {
        messages.add(message);
    }

    private void waitForRavenFly() {
        try {
            int waitingTime = new Random().nextInt(3);
            TimeUnit.SECONDS.sleep(waitingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
