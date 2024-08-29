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
        for (int i = 0; i < kingdoms.size(); i++) {
            for (int j = 0; j < kingdoms.size(); j++) {
                if (!kingdoms.get(i).equals(kingdoms.get(j))) {
                    var kingdomFrom = kingdoms.get(i);
                    var kingdomTo = kingdoms.get(j);
                    futures.add(sendRaven(kingdomFrom, kingdomTo)
                            .handle((result, ex) -> {
                                if (ex != null) {
                                    log.error(ex.getMessage());
                                    return false;
                                } else {
                                    log.info(String.format(
                                            "Crow successfully delivered message from %s to %s",
                                            kingdomFrom, kingdomTo));
                                    return true;
                                }
                            }));
                }
            }
        }
        futures.forEach(CompletableFuture::join);
    }

    private static CompletableFuture<Void> sendRaven(
            @NonNull Kingdom kingdomFrom, @NonNull Kingdom kingdomTo
    ) throws CrowFailedException {
        return CompletableFuture.runAsync(() -> kingdomFrom.sendMessage(kingdomTo));
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
