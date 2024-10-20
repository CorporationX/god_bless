package school.BJS2_37904;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        Kingdom kingdom = new Kingdom("Москва");
        Kingdom kingdom2 = new Kingdom("Екатеринбург");

        sendRaven(kingdom, kingdom2).handle((result, ex) -> {
            if (ex != null) {
                System.out.printf("Ворон не доставил письмо из королевства %s в королевство %s", kingdom.getName(), kingdom2.getName());
                System.out.println();
                System.out.println(ex.getMessage());
            } else {
                System.out.println(result);
            }
            return null;
        }).join();
    }

    private static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver, "Как у вас погода?");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
