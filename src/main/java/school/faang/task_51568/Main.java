package school.faang.task_51568;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        log.info("Пошли донаты");
        for (int i = 0; i < 100; i++) {
            tasks.add(CompletableFuture.runAsync(() -> organization.addDonation(10)));
        }

        tasks.forEach(CompletableFuture::join);
        log.info("Общий баланс организации: {}", organization.getBalance());
    }
}
