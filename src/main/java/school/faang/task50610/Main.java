package school.faang.task50610;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Kingdom> kingdoms = IntStream.range(0, 10)
                .boxed()
                .map(i -> new Kingdom(String.valueOf(i)))
                .toList();

        Random random = new Random();
        CompletableFuture.allOf(kingdoms.stream()
                        .map(kingdom ->
                                kingdom.sendRaven(kingdom, kingdoms.get(random.nextInt(kingdoms.size()))))
                        .toArray(CompletableFuture[]::new))
                .join();
    }
}
