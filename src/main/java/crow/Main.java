package crow;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        var kingdoms = initKingdoms();
        List<CompletableFuture<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < kingdoms.size() - 1; i++) {
            for (int j = i + 1; j < kingdoms.size(); j++) {
                futures.add(sendRaven(kingdoms.get(i), kingdoms.get(j)));
                futures.add(sendRaven(kingdoms.get(j), kingdoms.get(i)));
            }
        }
        futures.forEach(CompletableFuture::join);
    }

    private static CompletableFuture<Boolean> sendRaven(@NonNull Kingdom kingdomFrom, @NonNull Kingdom kingdomTo) {
        return CompletableFuture.runAsync(() -> kingdomFrom.sendMessage(kingdomTo))
                .handle((result, ex) -> handleError(ex, kingdomFrom, kingdomTo));
    }

    private static boolean handleError(Throwable ex, @NonNull Kingdom kingdomFrom, @NonNull Kingdom kingdomTo) {
        if (ex != null) {
            log.error(ex.getMessage());
            return false;
        } else {
            log.info(String.format(
                    "Crow successfully delivered message from %s to %s",
                    kingdomFrom.getName(), kingdomTo.getName()));
            return true;
        }
    }

    private static List<Kingdom> initKingdoms() {
        return List.of(
                new Kingdom("The North"),
                new Kingdom("The Vale of Arryn"),
                new Kingdom("The Riverlands"),
                new Kingdom("The Iron Islands"),
                new Kingdom("The Westerlands"),
                new Kingdom("The Crownlands"),
                new Kingdom("The Reach"),
                new Kingdom("The Stormlands"),
                new Kingdom("Dorne"));
    }
}
