package school.faang.googledocs;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        IntStream.range(1, 7).forEach(i -> document.addData("Глава%s".formatted(i), "данные%s".formatted(i)));

        List<DocumentSection> sections = List.of(
                new DocumentSection("Глава2", document),
                new DocumentSection("Глава3", document),
                new DocumentSection("Глава4", document),
                new DocumentSection("Глава5", document),
                new DocumentSection("Глава6", document)
        );

        List<CompletableFuture<Void>> results = sections.stream()
                .map(section -> CompletableFuture.runAsync(new DocumentSectionProcessor(section)))
                .toList();

        CompletableFuture.allOf(results.toArray(new CompletableFuture[0])).join();

        document.getDocument()
                .forEach((key, value) -> System.out.println("Раздел: " + key + " Данные: " + value));
    }
}
