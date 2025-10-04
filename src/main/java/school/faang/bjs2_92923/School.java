package school.faang.bjs2_92923;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    private final ExecutorService ex = Executors.newFixedThreadPool(5);

    public CompletableFuture<Integer> getTotalPoints() {
        return CompletableFuture.supplyAsync(() -> {
            team.stream().int

        }, ex);
    }
}
