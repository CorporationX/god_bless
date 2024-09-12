package ru.kraiush.threads.BJS2_18355;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AppSend_a_Raven {

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Wonderland");
        Kingdom kingdom2 = new Kingdom("Disneyland");

        AppSend_a_Raven app = new AppSend_a_Raven();

        System.out.print(String.join("", Collections.nCopies(110, "-")));
        try {
            System.out.println("\n <<<async answer>>> " + app.sendMessage(kingdom1, kingdom2).get());
            System.out.println(" <<<async answer>>> " + app.sendMessage(kingdom1, null).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.print(String.join("", Collections.nCopies(110, "-")));
    }

    CompletableFuture<String> sendMessage(Kingdom kingSender, Kingdom kingReceiver) throws InterruptedException {

        return CompletableFuture.supplyAsync(() -> {
            if (kingReceiver == null) {
                throw new IllegalArgumentException("The address of the Kingdom is missing!");
            } else {
                return "" + kingSender;
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("\nOh! We've caught an exception! - " + ex.getMessage());
                return kingSender + " your message has not been delivered!";
            }
            return "Hello, " + kingSender + " you message received!";
        });
    }
}
