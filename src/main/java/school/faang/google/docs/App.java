package school.faang.google.docs;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class App {
    private static final int NUM_OF_USERS = 10;

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        DocumentSection intro = new DocumentSection("Вступление", document);
        DocumentSection deadlocks = new DocumentSection("Дедлоки", document);
        DocumentSection threadSafeCollections = new DocumentSection("Потокобезопасные коллекции", document);
        DocumentSection immutableClasses = new DocumentSection("Имутабельные классы", document);
        List<DocumentSection> sections = List.of(intro, deadlocks, threadSafeCollections, immutableClasses);

        sections.forEach(section -> section.write(section.getId()));
        List<CompletableFuture<Void>> futures = sections.stream()
                .map(section -> CompletableFuture.runAsync(new DocumentSectionProcessor(section)))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Все задачи завершены:\n" + document))
                .join();

        System.out.println("Обработка одной секции несколькими пользователями одновременно: ");
        List<CompletableFuture<Void>> concurrentSectionFuture = IntStream.range(0, NUM_OF_USERS)
                .mapToObj(i -> CompletableFuture.runAsync(new DocumentSectionProcessor(intro)))
                .toList();
        CompletableFuture.allOf(concurrentSectionFuture.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Все задачи завершены:\n" + document))
                .join();
    }
}
