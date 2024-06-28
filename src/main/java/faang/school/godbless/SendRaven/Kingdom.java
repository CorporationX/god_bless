package faang.school.godbless.SendRaven;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public static CompletableFuture<String> sendMessage(Kingdom fromKingdom, Kingdom toKingdom) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean canDeliverMessage = checkMessageDelivery(fromKingdom, toKingdom);
            if (canDeliverMessage) {
                return "Message successfully sent from " + fromKingdom.getName() + " to " + toKingdom.getName();
            } else {
                return "Message failed to send from " + fromKingdom.getName() + " to " + toKingdom.getName();
            }
        });
    }

    private static boolean checkMessageDelivery(Kingdom fromKingdom, Kingdom toKingdom) {
        return true;
    }
}
