package school.faang.sendraven;

import java.util.concurrent.CompletableFuture;

public class RavenService {
    private final static int WORK_TO_TIME = 1_000;
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(WORK_TO_TIME);
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
