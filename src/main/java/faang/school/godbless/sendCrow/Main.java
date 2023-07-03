package faang.school.godbless.sendCrow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("North");
        Kingdom kingdom2 = new Kingdom("West");
        Kingdom kingdom3 = new Kingdom("East");

        CompletableFuture<String> future1 = kingdom1.sendMessage(kingdom2);
        CompletableFuture<String> future2 = kingdom2.sendMessage(kingdom3);
        CompletableFuture<String> future3 = kingdom3.sendMessage(kingdom1);

        CompletableFuture.allOf(future1, future2, future3).join();

        System.out.println("Messages sent and processed successfully");
    }
}
