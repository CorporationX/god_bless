package school.faang.send_crow_BJS2_37899;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Dorne");
        Kingdom kingdom2 = new Kingdom("The Riverlands");
        Kingdom kingdom3 = new Kingdom("The Vale");
        Kingdom kingdom4 = new Kingdom("The Iron Islands");

        List<String> exceptions = new ArrayList<>();

        List<CompletableFuture<Void>> futures = new ArrayList<>(List.of(
                Kingdom.sendRaven(kingdom1, kingdom2).handle((message, ex) -> {
                    if (ex != null) {
                        exceptions.add(ex.getMessage());
                    }
                    return null;
                }),
                Kingdom.sendRaven(kingdom3, kingdom1).handle((message, ex) -> {
                    if (ex != null) {
                        exceptions.add(ex.getMessage());
                    }
                    return null;
                }),
                Kingdom.sendRaven(kingdom4, kingdom3).handle((message, ex) -> {
                    if (ex != null) {
                        exceptions.add(ex.getMessage());
                    }
                    return null;
                })
        ));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    if (!exceptions.isEmpty()) {
                        exceptions.forEach(System.out::println);
                    }
                });
    }
}
