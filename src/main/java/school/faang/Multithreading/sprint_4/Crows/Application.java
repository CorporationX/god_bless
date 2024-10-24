package school.faang.Multithreading.sprint_4.Crows;

import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        Kingdom kingsAuro = new Kingdom("King's Auro");

        CompletableFuture<String> futureResultSend = ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        return "Ошибка: " + exception.getMessage();
                    } else {
                        return result;
                    }
                });

        System.out.println(futureResultSend.join());

        ravenService.sendRaven(kingsLanding, kingsAuro)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Ошибка: " + exception.getMessage());
                    } else {
                        System.out.println(result);
                    }
                    return null;
                })
                .join();
    }
}
