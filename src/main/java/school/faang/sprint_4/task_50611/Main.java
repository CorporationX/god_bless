package school.faang.sprint_4.task_50611;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int NUMBER_OF_SENDS = 100;

    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        List<CompletableFuture<String>> completableFutures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_SENDS; i++) {
            completableFutures.add(ravenService.sendRaven(winterfell, kingsLanding)
                    .handle((result, exception) -> {
                        if (exception != null) {
                            System.out.println("Ошибка: " + exception.getMessage());
                        } else {
                            System.out.println(result);
                        }
                        return null;
                    }));
        }

        completableFutures.forEach(CompletableFuture::join);
    }
}
