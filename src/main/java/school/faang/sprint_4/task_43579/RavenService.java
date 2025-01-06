package school.faang.sprint_4.task_43579;

import java.util.concurrent.CompletableFuture;

public class RavenService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Ворон отправлен из " + sender.name() + " в " + receiver.name());
            return sender.sendMessage(receiver);
        });
    }
}