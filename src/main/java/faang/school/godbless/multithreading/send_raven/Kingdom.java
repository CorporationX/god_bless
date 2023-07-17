package faang.school.godbless.multithreading.send_raven;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Kingdom {
    private final String name;
    private final Random random;

    public Kingdom(String name) {
        this.name = name;
        random = new Random();
    }

    public CompletableFuture<String> sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("The raven is delivering a message from " + kingdom1.name + " to " + kingdom2.name);

            try {
                Thread.sleep(random.nextInt(random.nextInt(1000, 5000)));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            if (random.nextInt(1, 4) == 1) {
                throw new RuntimeException("The raven didn't deliver the message");
            }

            return "Message from " + kingdom1.name + " to " + kingdom2.name;
        });
    }
}
