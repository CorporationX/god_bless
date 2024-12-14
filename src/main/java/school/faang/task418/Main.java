package school.faang.task418;

import school.faang.task418.got.Kingdom;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Kingdom winterfall = new Kingdom("WinterFall");
        Kingdom highgarden = new Kingdom("Highgarden");

        CompletableFuture<String> firstRavenTravel = winterfall.sendMessage(highgarden)
                .handle((message, throwable) -> {
                    if (throwable == null) {
                        return message;
                    } else {
                        return throwable.getMessage();
                    }
                });
        CompletableFuture<String> secondRavenTravel = winterfall.sendMessage(winterfall)
                .handle((message, throwable) -> {
                    if (throwable == null) {
                        return message;
                    } else {
                        return throwable.getLocalizedMessage();
                    }
                });

        CompletableFuture<Void> allRaven = CompletableFuture.allOf(firstRavenTravel, secondRavenTravel);
        allRaven.join();

        try {
            System.out.println(firstRavenTravel.get());
            System.out.println(secondRavenTravel.get());
            winterfall.shutdown();
            highgarden.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
