package school.faang.crow;

import java.util.concurrent.CompletableFuture;

public record Kingdom(String name) {
    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.5) {
            throw new Exception("Ворон не смог доставить сообщение из "
                    + name + " в " + receiver.name());
        }
        return "Сообщение успешно доставлено из " + name + " в " + receiver.name();
    }

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
