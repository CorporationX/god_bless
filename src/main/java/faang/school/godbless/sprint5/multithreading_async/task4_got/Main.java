package faang.school.godbless.sprint5.multithreading_async.task4_got;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Дом Старков");
        Kingdom kingdom2 = new Kingdom("Дом Ланнистеров");

        CompletableFuture<Kingdom> kingdomCompletableFuture = Kingdom.sendRaven(kingdom1, kingdom2);

        CompletableFuture<Object> handle = kingdomCompletableFuture.handle((s, t) -> s != null ? "Сообщение доставлено успешно!" : "Ошибка!");

        System.out.println(handle.get());
    }
}
