package school.faang.stream3.weasleyfamily;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int MAX_WAIT_MINUTES = 5;
    private static final int WEASLEY_FAMILY_MEMBERS_COUNT = 9;
    private static final List<String> TASKS_DESCRIPTION = List.of(
            "уборка", "готовка", "стирка и починка одежды", "сборы в Хогвартс", "уход за домашними животными",
            "помощь в семейном бизнесе", "устранение магических последствий", "приём гостей", "уход за садом и " +
                    "огородом", "поддержание магических предметов в рабочем состоянии", "забота о детях",
            "контроль за домашним обучением до школы", "заготовка припасов", "ремонт дома заклинаниями",
            "проверка совиной почты", "создание и починка самодельных вещей", "участие в Ордена Феникса",
            "прятание опасных артефактов", "помощь соседям-маглам", "отпугивание гномов с огорода",
            "приготовление зелий для домашнего пользования", "уход за камином с летучим порохом", "наблюдение за " +
                    "детьми, летающими на мётлах", "успокаивание магических существ", "слежка за близнецами и их " +
                    "экспериментами", "шитьё и вязание вручную и магией", "чистка волшебных котлов и инвентаря",
            "помощь в праздниках и семейных мероприятиях", "распаковка и сортировка школьных вещей", "поддержка " +
                    "камуфляжа дома от маглов");

    public static void main(String[] args) {
        List<Chore> taskList = TASKS_DESCRIPTION.stream()
                .map(Chore::new)
                .toList();

        ExecutorService executorService = Executors.newFixedThreadPool(WEASLEY_FAMILY_MEMBERS_COUNT);

        for (Chore task : taskList) {
            executorService.execute(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
