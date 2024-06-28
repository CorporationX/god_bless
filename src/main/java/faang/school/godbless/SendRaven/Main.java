package faang.school.godbless.SendRaven;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");

        CompletableFuture<String> messageFuture = Kingdom.sendMessage(kingdom1, kingdom2);

        messageFuture.thenAccept(message -> {
            System.out.println("Received message: " + message);
        }).join();
    }
}