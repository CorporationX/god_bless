package faang.school.godbless.send_a_crow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public String sendRaven(Kingdom kingdom) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
            "A message from " + this.getName() + " to " + kingdom.getName());

        future.handle((message, ex) -> {
            if (ex != null){
                throw new RuntimeException("Raven was unable to deliver the message");
            }

            return message;
        });

        return future.get();
    }

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("kingdom1");
        Kingdom kingdom2 = new Kingdom("kingdom2");
        try {
            System.out.println(kingdom1.sendRaven(kingdom2));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
