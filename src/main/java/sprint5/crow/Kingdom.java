package sprint5.crow;

import lombok.Data;

import java.util.concurrent.CompletableFuture;

@Data
public class Kingdom {
    private static final String SHIPMENT_INFORMATION = "Message delivered to %s\n";
    private final String name;

    public CompletableFuture<String> sendRaven(Kingdom toKingdom, String message) {
        return CompletableFuture.supplyAsync(() -> {
            Crow crow = new Crow(toKingdom.name, message);
            if (crow.willFlightBeGood()) {
                throw new UnsuccessfulFlightException("Raven had an accident on his way to " + toKingdom.name);
            }
            return crow;
        }).handle((crow, ex) -> crow != null ? String.format(SHIPMENT_INFORMATION, toKingdom.name) : ex.getMessage());
    }
}
