package school.faang.multithreading.asynchronism.send.raven;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom kingdom1 = new Kingdom("kingdom1");
        Kingdom kingdom2 = new Kingdom("kingdom2");

        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    ravenService.sendRaven(kingdom1, kingdom2)
                            .handle((result, error) -> {
                                if (error == null) {
                                    log.info("Успешная отправка на попытке №{}", i);
                                } else {
                                    log.error("Ошибка при отправке на попытке №{}: {}", i, error.getMessage());
                                }
                                return null;
                            }).join();
                });
    }
}