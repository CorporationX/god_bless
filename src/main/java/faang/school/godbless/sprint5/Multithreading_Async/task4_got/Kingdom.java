package faang.school.godbless.sprint5.Multithreading_Async.task4_got;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@AllArgsConstructor
public class Kingdom {

    private String name;

    public void sendMessage(Kingdom otherKingdom) {
        System.out.println("Зима близко.");
    }

    public static CompletableFuture<Kingdom> sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        return CompletableFuture.supplyAsync(() -> {

            if (new Random().nextBoolean()) {
                throw new RuntimeException("kek lol");
            }
            kingdom1.sendMessage(kingdom2);
            return kingdom1;
        });
    }
}
