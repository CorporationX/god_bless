package faang.school.godbless.sprint_3.multithreading_future.send_the_crow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    @SneakyThrows
    public static void main(String[] args) {
        Kingdom stark = new Kingdom("Stark");
        Kingdom talli = new Kingdom("Talli");
        Kingdom greyjoy = new Kingdom("Greyjoy");
        CompletableFuture<String> firstResult = CompletableFuture.supplyAsync(() -> sendRaven(stark, talli));
        firstResult.handle((line, exception) -> {
                    if (exception != null) {
                        System.out.println(exception.getMessage());
                        throw new RuntimeException();
                    }
                    return line;
                })
                .thenAccept(System.out::println);
        CompletableFuture<String> secondResult = CompletableFuture.supplyAsync(() -> sendRaven(talli, greyjoy));
        secondResult.handle((line, exception) -> {
                    if (exception != null) {
                        System.out.println(exception.getMessage());
                        throw new RuntimeException();
                    }
                    return line;
                })
                .thenAccept(System.out::println);
        Thread.sleep(7000);
    }

    public static String sendRaven(Kingdom first, Kingdom second) {
        System.out.printf("Отправляем ворона из %s в королевство: %s%n", first.name, second.name);
        int random = ThreadLocalRandom.current().nextInt(2);
        if (random == 0) {
            throw new IllegalArgumentException("Вашего ворона который летел из " + first.name + " убито");
        }
        return "Сообщение отправлено из " + first.name + " в " + second.name;
    }
}