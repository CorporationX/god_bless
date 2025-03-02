package bjs2_62812;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static final int WAITING_TERMINATION_TIMEOUT_SECONDS = 3;
    public static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;

    public static void main(String[] args) {
        var document = new CollaborativeDocument();

        var sections = List.of(
                createSection(document, "Титульный лист", "Важный документ"),
                createSection(document, "Оглавление", "Раздел 1, а потом раздел 2"),
                createSection(document, "Раздел 1", "Важное вступление"),
                createSection(document, "Раздел 2", "Тут пусто, т.к. умных мыслей больше нет"),
                createSection(document, "Заключение", "Работа проделана, результаты получены"));

        var executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (var section : sections) {
            var sectionProcessor = new DocumentSectionProcessor(section);
            executor.submit(sectionProcessor);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITING_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Не дождались окончания потоков: {}", e.getMessage(), e);
            executor.shutdownNow();
        }

        log.info("Содержимое документа");
        for (var section : sections) {
            var sectionData = section.read();
            if (sectionData.isPresent()) {
                log.info(sectionData.get());
            } else {
                log.info("Секция {} не найдена в документе", section.getId());
            }
        }
    }

    private static DocumentSection createSection(CollaborativeDocument document, String sectionId, String data) {
        var section = new DocumentSection(sectionId, document);
        section.write(data);

        return section;
    }
}
