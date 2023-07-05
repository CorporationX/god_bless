package faang.school.godbless.multithreading.send_raven;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom1");
        Kingdom kingdom2 = new Kingdom("Kingdom2");

        for (int i = 0; i < 3; i++) {
            String result = kingdom1.sendRaven(kingdom1, kingdom2).handle(
                    (message, throwable) -> {
                        if (throwable != null) {
                            return "Empty. Cause of: " + throwable.getCause().getMessage();
                        }
                        return message;
                    }).join();

            System.out.println("Message: " + result);
        }
    }
}
