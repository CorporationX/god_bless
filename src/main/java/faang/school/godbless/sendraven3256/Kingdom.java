package faang.school.godbless.sendraven3256;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    static final Kingdom NORTH = new Kingdom("The North");
    static final Kingdom ARRYN = new Kingdom("Vale of Arryn");
    static final Kingdom WESTERLANDS = new Kingdom("Westerlands");
    static final Kingdom STORMLANDS = new Kingdom("The Stormlands");

    public CompletableFuture<Kingdom> sendMessage(Kingdom kingdom, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Message was sent to " + kingdom.getName());
            return kingdom;
        }, executor);
    }
}
