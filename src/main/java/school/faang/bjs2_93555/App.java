package school.faang.bjs2_93555;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();
        collaborativeDocument.getSections().put("Подарки", "Приятные подарки");
        collaborativeDocument.getSections().put("Игрушки", "Веселые игрушки");
        collaborativeDocument.getSections().put("Сувениры", "Интересные сувениры");
        collaborativeDocument.getSections().put("Инструменты", "Умные инструменты");
        List<Thread> threads = List.of(
                new Thread(new DocumentSectionProcessor(new DocumentSection("Подарки", collaborativeDocument))),
                new Thread(new DocumentSectionProcessor(new DocumentSection("Игрушки", collaborativeDocument))),
                new Thread(new DocumentSectionProcessor(new DocumentSection("Сувениры", collaborativeDocument))),
                new Thread(new DocumentSectionProcessor(new DocumentSection("Инструменты", collaborativeDocument)))
        );
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Все потоки завершили свою работу.");
    }
}
