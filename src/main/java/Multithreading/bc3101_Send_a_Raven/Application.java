package Multithreading.bc3101_Send_a_Raven;

import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom1", "Hello");
        Kingdom kingdom2 = new Kingdom("Kingdom2", "Privet");

        CompletableFuture<String> res = kingdom1.sendRaven(kingdom1, kingdom2);
        res.handle((successResult, exception) -> {
            if (exception != null) {
                System.out.println("Message not sent");
            } else {
                System.out.println(successResult);
            }
            return "Message processed";
        }).join();
    }
}
